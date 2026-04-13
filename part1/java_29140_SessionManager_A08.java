import java.security.Permission;
import java.security.SecurityPermission;

public class java_29140_SessionManager_A08 {

    // Implement SecurityManager
    public static class MySecurityManager extends SecurityManager {
        public void checkPermission(Permission perm) {
            if (!(perm instanceof SecurityPermission)) {
                throw new SecurityException("Un经授权的权限：" + perm);
            }
        }

        public void checkExit(int status) {
            // 不允许退出程序
        }
    }

    public static void main(String[] args) {

        // 设置自己的SecurityManager
        SecurityManager sm = new MySecurityManager();
        SessionContext ctx = new SessionContext(sm, new AuthenticationInfo[] { new AuthenticationInfo("Admin", "AdminPassword") });

        // 使用SessionContext
        try {
            // 允许用户访问
            ctx.setContext(SecurityToken.loginModuleCall(new String[] { "Admin" }));

            System.out.println("成功登录。用户：" + ctx.getSubject().getPrincipal());

            // 关闭SessionContext
            ctx.setContext(SecurityToken.logoutModuleCall(SecurityToken.NONE));
        } catch (Exception e) {
            System.out.println(e);
       
            // 如果发生错误，则重新获取上下文
            ctx = new SessionContext(sm, new AuthenticationInfo[] { new AuthenticationInfo("Admin", "AdminPassword") });
            ctx.setContext(SecurityToken.loginModuleCall(new String[] { "Admin" }));
            System.out.println("重新尝试登录。用户：" + ctx.getSubject().getPrincipal());
        }

        System.out.println("成功登出。用户：" + ctx.getSubject().getPrincipal());
    }
}