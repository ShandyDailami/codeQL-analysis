import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_30331_FileScanner_A07 {
    private static final Logger logger = Logger.getLogger(AuthFailureFileScanner.class.getName());
    private final File rootDirectory;

    public java_30331_FileScanner_A07(File rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    public void scan(String keyword) {
        try (Scanner scanner = new Scanner(System.in)) {
            logger.info("Enter a password:");
            String password = scanner.nextLine();

            if (password.equals(keyword)) {
                logger.warning("Password entered is incorrect.");
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        AuthFailureFileScanner fileScanner = new AuthFailureFileScanner(rootDirectory);

        fileScanner.scan("correctpassword");

        logger.info("Scanning files in directory: " + rootDirectory.getAbsolutePath());
        fileScanner.scan("incorrectpassword");
    }
}