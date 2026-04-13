import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09510_FileScanner_A01 {
    private static final String DIRECTORY = "path_to_directory";
    private static final String FILE_EXTENSION = "extension";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Security-sensitive operation here.
                        // For example, checking if a line contains a password or a secret key.
                        if (containsPasswordOrSecretKey(line)) {
                            System.out.println("Access to file: " + file.getPath() + " is restricted.");
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean containsPasswordOrSecretKey(String line) {
        // Implement your own logic here to check if a line contains a password or a secret key.
        // This is a simple example and might not be suitable for all use cases.
        return line.contains("password") || line.contains("secret_key");
    }
}