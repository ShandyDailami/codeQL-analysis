import java.io.File;
import java.util.Scanner;
import java.util.FileScanner;

public class java_05549_FileScanner_A07 {
    private static final String AUTH_FILE = "auth.txt"; // the file where authentication info is stored

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your password:");
        String userPassword = scanner.nextLine();

        if (authenticateUser(userPassword)) {
            FileScanner fileScanner = new FileScanner(new File(AUTH_FILE));
            fileScanner.useDelimiter("\\Z");
            while (fileScanner.hasNext()) {
                String fileContents = fileScanner.next();
                System.out.println(fileContents);
            }
            fileScanner.close();
        } else {
            System.out.println("Authentication failed.");
        }
    }

    private static boolean authenticateUser(String userPassword) {
        // implement your authentication logic here
        // for the sake of example, we assume correct password
        return userPassword.equals("correctPassword");
    }
}