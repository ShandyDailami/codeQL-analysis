import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37055_FileScanner_A07 {
    private static final String AUTH_FAILURE_DIR = "/path/to/auth/failure/dir";

    public static void main(String[] args) {
        File authFailureDir = new File(AUTH_FAILURE_DIR);
        File[] authFailures = authFailureDir.listFiles();

        if (authFailures != null) {
            for (File file : authFailures) {
                try {
                    detectAuthFailure(new File(file.getPath()));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void detectAuthFailure(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("authentication failure")) {
                System.out.println("Found authentication failure in file: " + file.getName());
                // Add more logic here to handle the failure, like logging the event, sending alert, etc.
            }
        }
        scanner.close();
    }
}