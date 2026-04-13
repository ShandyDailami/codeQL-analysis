import java.security.Permission;
import java.security.SecurityManager;
import java.security.UnsupportedOperationException;
import java.util.List;

public class java_19811_XMLParser_A01 implements SecurityManager {
    private List<Permission> permissions;

    public java_19811_XMLParser_A01(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean checkPermission(Permission p) {
        for (Permission permission : permissions) {
            if (permission.getClass().getName().equals(p.getClass().getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void checkAccess(String action) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}

public class Main {
    public static void main(String[] args) {
        // Add the permissions here
        List<Permission> permissions = List.of(new RuntimePermission("access_to_file"));

        SecurityManager securityManager = new XMLParserSecurityManager(permissions);

        // Use the securityManager
        try {
            XMLParser parser = new XMLParser(securityManager);
            parser.parse("path_to_your_xml_file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}