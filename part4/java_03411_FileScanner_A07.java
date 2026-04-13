import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03411_FileScanner_A07 {

    // This is a dummy method for authentication, you should replace this with your actual authentication method
    private static boolean authenticate(String username, String password) {
        // Placeholder method, replace this with your actual authentication method
        return username.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authenticate(username, password)) {
            System.out.println("Authenticated successfully!");
        } else {
            System.out.println("Failed to authenticate!");
            return;
        }

        System.out.println("Reading files...");

        File directory = new File(".");
        File[] files = directory.listFiles();
        assert files != null;

        // Loop through all files in the directory
        for (File file : files) {
            if (file.getName().startsWith("A")) {
                System.out.println("Found file: " + file.getName());
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
                fileScanner.close();
            }
        }
    }
}