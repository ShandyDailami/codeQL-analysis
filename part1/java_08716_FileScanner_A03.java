import java.io.File;
import java.util.Scanner;

public class java_08716_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        if (fileName.endsWith(".txt")) {
                            System.out.println("Processing file: " + fileName);
                            readFile(file);
                        }
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static void readFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This line will contain a string like "1;John Doe;john.doe@example.com".
                // We're assuming here that the injection attack is based on the first semicolon (";")
                // in the string, and the injection is based on the rest of the string.
                String[] values = line.split(";");
                String username = values[1];  // Username should not be affected by the injection attack.
                String email = values[2];    // Email should not be affected by the injection attack.
                System.out.println("Username: " + username);
                System.out.println("Email: " + email);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getName());
        }
    }
}