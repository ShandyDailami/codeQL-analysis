import java.io.File;
import java.util.Scanner;

public class java_31777_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileContent = readFileContent(file);
                        String fileName = file.getName();
                        System.out.println("File Name: " + fileName);
                        System.out.println("File Content: " + fileContent);

                        // The following line is vulnerable for SQL injection
                        // This is a bad example of how to prevent injection
                        // String query = "SELECT * FROM users WHERE username = '" + fileName + "'";

                        // It's dangerous to use user-provided input in a SQL query
                        // This can lead to SQL injection vulnerabilities
                        // String query = "SELECT * FROM users WHERE username = " + fileName;

                        // Here's the correct way to prevent SQL injection
                        // Use parameterized queries or stored procedures
                        String query = "SELECT * FROM users WHERE username = ?";

                        // This is a bad example of how to prevent injection
                        // This is why we use prepared statements with JDBC
                        // String username = scanner.nextLine();

                        // Here's the correct way to prevent SQL injection
                        // Use parameterized queries or stored procedures
                        String username = "admin";

                        // This is a bad example of how to prevent injection
                        // This is why we use prepared statements with JDBC
                        // String password = scanner.nextLine();

                        // Here's the correct way to prevent SQL injection
                        // Use parameterized queries or stored procedures
                        String password = "password";

                        // This is a bad example of how to prevent injection
                        // This is why we use prepared statements with JDBC
                        // JDBCExample.executeQuery(query);

                        // Here's the correct way to prevent SQL injection
                        // Use parameterized queries or stored procedures
                        JDBCExample.executeQuery(query, username, password);
                    }
                }
            }
        } else {
            System.out.println("Invalid directory path");
        }

        scanner.close();
    }

    private static String readFileContent(File file) {
        String content = "";
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                content += scanner.nextLine();
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
}