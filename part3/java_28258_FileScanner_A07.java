import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28258_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/AuthFailure.log"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("FAILURE")) {
                String userId = parseUserId(line);
                if (userId != null) {
                    System.out.println("User: " + userId + " failed to authenticate.");
                }
            }
        }

        scanner.close();
    }

    private static String parseUserId(String line) {
        // TODO: Implement your own logic to parse user id from log line
        // Hint: You may want to split the line into tokens and use the third one as the user id
        // e.g. for line "user1:password wrong_password" the user id is "user1"
        // This is a placeholder. You should replace it with your own implementation.
        return null;
    }
}