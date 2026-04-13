import java.io.File;
import java.util.Scanner;

public class java_02609_FileScanner_A01 {
    private static final String DIRECTORY = "C:/path/to/directory";
    private static final String EXTENSION = ".*\\.txt";

    public static void main(String[] args) {
        File file = new File(DIRECTORY);

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles((dir, name) -> name.endsWith(EXTENSION));

                if (files != null) {
                    for (File f : files) {
                        try (Scanner scanner = new Scanner(f)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println(line);
                           
                                // Here you could implement security-sensitive operations related to A01_BrokenAccessControl.
                                // For instance, you could check if the line contains a specific string or perform some other security-sensitive operation.
                            }
                        }
                    }
                }
            }
        }
    }
}