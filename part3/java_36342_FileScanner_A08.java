import java.io.File;
import java.security.Permission;
import java.util.Scanner;

public class java_36342_FileScanner_A08 {
    private static final String SECURITY_FAILURE = "Security failure";
    private static final String PATH = "C:\\path\\to\\your\\file\\or\\directory";

    public static void main(String[] args) {
        File file = new File(PATH);
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                checkLine(line);
            }
            scanner.close();
        } else {
            System.out.println("File does not exist.");
        }
    }

    private static void checkLine(String line) {
        if (line.contains(SECURITY_FAILURE)) {
            System.out.println("Security failure found in line: " + line);
            Permission deniedPermission = new Permission("deny");
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkPermission(deniedPermission);
            }
        }
    }
}