package thymeleafexamples.sfs.application;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.DependsOn;
import org.springframework.beans.factory.annotation.Autowired;

import thymeleafexamples.sfs.business.services.CustomerService;

import java.util.Map;
import java.util.HashMap;

import thymeleafexamples.sfs.realm.CustomerRealm;

@Configuration
public class SpringWebShiroConfig {
	@Bean
  public HashedCredentialsMatcher credentialsMatcher() {
    final HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
    //credentialsMatcher.setHashAlgorithmName("md5");
    return credentialsMatcher;
  }

  @Autowired
  private CustomerService customerService;

  @Bean(name="customerRealm")
  @DependsOn("lifecycleBeanPostProcessor")
  public CustomerRealm customerRealm(final HashedCredentialsMatcher credentialsMatcher) {
    final CustomerRealm customerRealm = new CustomerRealm();
    customerRealm.setCustomerService(customerService);
    return customerRealm;
  }

  @Bean
  public DefaultWebSecurityManager securityManager(final CustomerRealm customerRealm) {
    final DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(customerRealm);
    return securityManager;
  }

  @Bean
  public MethodInvokingFactoryBean methodInvokingFactoryBean(final DefaultWebSecurityManager securityManager) {
    final MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
    methodInvokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
    methodInvokingFactoryBean.setArguments(new Object[]{ securityManager });
    return methodInvokingFactoryBean;
  }

  @Bean
  public ShiroFilterFactoryBean shiroFilter(final DefaultWebSecurityManager securityManager) {
    final ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
    shiroFilter.setSecurityManager(securityManager);
    shiroFilter.setLoginUrl("/signin");
    Map<String, String> filterChainDefinitionMap = new HashMap<String, String>();
    filterChainDefinitionMap.put("/signup", "anon");
    filterChainDefinitionMap.put("/signin", "anon");
    filterChainDefinitionMap.put("/index", "authc");
    filterChainDefinitionMap.put("/menu", "authc");
    filterChainDefinitionMap.put("/order", "authc");
    shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
    return shiroFilter;
  }

  @Bean
  public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
    return new LifecycleBeanPostProcessor();
  }
}
