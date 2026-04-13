import java.io.File;
import java.util.Scanner;

public class java_04478_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        String extension = fileName.substring(fileName.lastIndexOf("."));

                        if (extension.equals(".txt") || extension.equals(".csv") || extension.equals(".json")) {
                            try {
                                System.out.println("Reading file: " + file.getAbsolutePath());
                                Scanner fileScanner = new Scanner(file);

                                while (fileScanner.hasNextLine()) {
                                    String line = fileScanner.nextLine();
                                    System.out.println("Line: " + line);

                                    // This is a security-sensitive operation related to injection
                                    // We are trying to insert an SQL query into the line
                                    String sqlQuery = "SELECT * FROM Users WHERE username = '" + line + "'";
                                    System.out.println("SQL Query: " + sqlQuery);
                                }

                                fileScanner.close();
                            } catch (Exception e) {
                                System.out.println("Error processing file: " + file.getAbsolutePath());
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }
}