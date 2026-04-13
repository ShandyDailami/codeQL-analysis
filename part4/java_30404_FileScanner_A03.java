import java.io.File;
import java.util.Scanner;

public class java_30404_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            File[] listOfFiles = directory.listFiles();

            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        String name = file.getName();

                        // Example of a security-sensitive operation:
                        // Injection attack:
                        // The following line uses the file name as an SQL command.
                        // This is a potential injection attack, as it allows an attacker to execute arbitrary SQL commands.
                        // This is a simple example, but real-world applications would use a more secure method.
                        String sqlCommand = "SELECT * FROM " + name;

                        // Do something with the file...
                    }
                }
            }
        } else {
            System.out.println("The provided path does not exist or is not a directory.");
        }

        scanner.close();
    }
}