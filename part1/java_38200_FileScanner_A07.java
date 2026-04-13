import java.io.File;
import java.util.Scanner;

public class java_38200_FileScanner_A07 {

    private static final String FILE_PATH = "path/to/file";  // Replace with your file path

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                System.out.println("File does not exist!");
                return;
            }

            if (!file.canRead()) {
                System.out.println("You do not have permission to read the file!");
                return;
            }

            if (file.length() == 0) {
                System.out.println("The file is empty!");
                return;
            }

            System.out.println("File content:");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
            fileScanner.close();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}