import java.io.File;
import java.util.Scanner;

public class java_01270_FileScanner_A08 {

    private static final String DIR_PATH = "/path/to/directory";
    private static final String SEARCH_STRING = "search string";

    public static void main(String[] args) {
        File dir = new File(DIR_PATH);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (authenticate(password)) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (fileContainsSearchString(file, SEARCH_STRING)) {
                            System.out.println("File contains search string: " + file.getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("Authentication failed!");
        }

        scanner.close();
    }

    private static boolean authenticate(String password) {
        // Implement authentication logic here
        // This is just a placeholder, replace it with actual authentication logic
        return password.equals("correct password");
    }

    private static boolean fileContainsSearchString(File file, String searchString) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(searchString)) {
                    return true;
                }
            }
        }
        return false;
    }
}