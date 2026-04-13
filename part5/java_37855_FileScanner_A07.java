import java.io.File;
import java.util.Scanner;

public class java_37855_FileScanner_A07 {

    private static final String DIRECTORY_PATH = "/path/to/directory";
    private static final String SECRET_KEY = "some-secret-key";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter secret key:");
        String enteredKey = scanner.nextLine();

        if (enteredKey.equals(SECRET_KEY)) {
            System.out.println("Authentication successful!");
            File directory = new File(DIRECTORY_PATH);

            if (directory.exists()) {
                File[] files = directory.listFiles();

                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println("File: " + file.getName());
                            // Here, we're only interested in authenticating file names.
                            // For security-sensitive operations, we would need a more complex authentication mechanism.
                        } else if (file.isDirectory()) {
                            System.out.println("Directory: " + file.getName());
                            // Similarly, here, we're only interested in authenticating directories.
                            // For security-sensitive operations, we would need a more complex authentication mechanism.
                        }
                    }
                }
            } else {
                System.out.println("Directory not found!");
            }
        } else {
            System.out.println("Authentication failed!");
        }

        scanner.close();
    }
}