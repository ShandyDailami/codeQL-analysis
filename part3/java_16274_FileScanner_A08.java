import java.io.File;
import java.util.Scanner;

public class java_16274_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory"; // replace with your directory path
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the password:");
        String password = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] secretFiles = directory.listFiles((dir, name) -> name.endsWith("_secret"));

        if (secretFiles != null) {
            for (File file : secretFiles) {
                if (file != null && (file.exists() && file.canRead())) {
                    if (file.getName().endsWith("_secret")) {
                        System.out.println("Reading file: " + file.getName());

                        // Reading the secret file content
                        try (Scanner fileScanner = new Scanner(file)) {
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                System.out.println(line);
                            }
                        }

                        System.out.println("End of file content.");
                    }
                }
            }
        }

        scanner.close();
    }
}