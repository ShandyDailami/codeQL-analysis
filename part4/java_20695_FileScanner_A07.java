import java.io.File;
import java.util.Scanner;

public class java_20695_FileScanner_A07 {

    private static final String PATH = "path_to_your_directory";
    private static final String FILE_EXTENSION = "extension_of_the_files";

    public static void main(String[] args) {
        File directory = new File(PATH);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your username:");
        String username = scanner.nextLine();

        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        File[] authFailures = directory.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));

        if (authFailures == null) {
            System.out.println("No auth failures found in the specified directory!");
            return;
        }

        boolean authFailureFound = false;

        for (File file : authFailures) {
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();

                    if (line.contains(username) && line.contains(password)) {
                        authFailureFound = true;
                        System.out.println("Auth failure found in file: " + file.getAbsolutePath());
                        break;
                    }
                }
            }

            if (authFailureFound) {
                break;
            }
        }

        if (!authFailureFound) {
            System.out.println("No auth failures found in the specified directory!");
        }
    }
}