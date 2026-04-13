import java.security.Permission;
import java.security.SecurityPermission;
import java.util.List;

public class java_20524_XMLParser_A07 extends SecurityManager {

    @Override
    public void checkPermission(Permission perm) {
        // we don't allow any permission
    }

    @Override
    public void checkPermissions(List<Permission> perms) {
        // we don't allow any permission
    }
}

public class Main {

    public static void main(String[] args) {

        XMLParser parser = new XMLParser();
        parser.setSecurityManager(new MySecurityManager());

        try {
            parser.parse("src/test.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}