import java.io.File;
import java.util.Scanner;

public class java_28795_FileScanner_A08 {
    private static final String SECURITY_VIOLATION_ERROR = "Security violation error!";
    private static boolean isValidPath(String path) {
        File file = new File(path);
        return file.exists();
    }

    private static void checkFileIntegrity(String path) throws SecurityException {
        File file = new File(path);
        if (file.exists()) {
            if (!file.canRead(path)) {
                throw new SecurityException(SECURITY_VIOLATION_ERROR);
            }
            if (!file.setReadable(true, path)) {
                throw new SecurityException(SECURITY_VIOLATION_ERROR);
            }
        } else {
            throw new SecurityException(SECURITY_VIOLATION_ERROR);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String path = scanner.nextLine();

        if (isValidPath(path)) {
            try {
                checkFileIntegrity(path);
                System.out.println("File integrity check passed!");
            } catch (SecurityException se) {
                System.out.println(se.getMessage());
            }
        } else {
            System.out.println("Invalid file path!");
        }
    }
}