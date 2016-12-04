package thymeleafexamples.sfs.application;

import javax.servlet.*;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.apache.shiro.web.servlet.ShiroFilter;

public class SpringServletInitializer extends AbstractDispatcherServletInitializer {

    public static final String CHARACTER_ENCODING = "UTF-8";


    public SpringServletInitializer() {
        super();
    }

    protected WebApplicationContext createServletApplicationContext() {
        final AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringWebConfig.class, SpringWebJpaConfig.class, SpringWebShiroConfig.class);
        return context;
    }

    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }

    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
      final CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
      encodingFilter.setEncoding(CHARACTER_ENCODING);
      encodingFilter.setForceEncoding(true);
      final DelegatingFilterProxy filterProxy = new DelegatingFilterProxy("shiroFilter");
      filterProxy.setTargetFilterLifecycle(true);
      return new Filter[] { encodingFilter, filterProxy};
    }

}
