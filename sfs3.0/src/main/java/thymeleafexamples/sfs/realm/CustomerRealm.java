package thymeleafexamples.sfs.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import thymeleafexamples.sfs.business.services.CustomerService;
import thymeleafexamples.sfs.business.entities.Customer;

public class CustomerRealm extends AuthorizingRealm {

	private CustomerService customerService;

  public void setCustomerService(CustomerService customerService) {
    this.customerService = customerService;
  }

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
      String username = (String)principals.getPrimaryPrincipal();

      SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
      return authorizationInfo;
  }

	@Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    String username = (String)token.getPrincipal();
    Customer customer = customerService.findByName(username);
    if(customer == null) {
       throw new UnknownAccountException();
    }

    return new SimpleAuthenticationInfo(username, customer.getPassword(), getName());
  }

  @Override
  public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
      super.clearCachedAuthorizationInfo(principals);
  }

  @Override
  public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
      super.clearCachedAuthenticationInfo(principals);
  }

  @Override
  public void clearCache(PrincipalCollection principals) {
      super.clearCache(principals);
  }

  public void clearAllCachedAuthorizationInfo() {
      getAuthorizationCache().clear();
  }

  public void clearAllCachedAuthenticationInfo() {
      getAuthenticationCache().clear();
  }

  public void clearAllCache() {
      clearAllCachedAuthenticationInfo();
      clearAllCachedAuthorizationInfo();
  }
}
