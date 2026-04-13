import java.io.File;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.Permission;
import java.security.Policy;

public class java_00653_XMLParser_A01 {
    private Policy policy;

    public java_00653_XMLParser_A01(Policy policy) {
        this.policy = policy;
    }

    public void parse(String filePath) throws IOException, AccessControlException {
        File file = new File(filePath);

        if (policy.check(new FilePermission(file.getAbsolutePath(), "read"))) {
            // parse file
        } else {
            throw new AccessDeniedException("Access to file is denied");
        }
    }
}