import java.io.File;
import java.util.Scanner;

public class java_18610_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file path: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        if (file.exists()) {
            try {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);

                    // Injection example.
                    // This line will execute a command given by the user.
                    Runtime.getRuntime().exec(line);
                }
                fileScanner.close();
            } catch (Exception e) {
                System.out.println("Error while reading file: " + e.getMessage());
            }
        } else {
            System.out.println("File does not exist: " + filePath);
        }
    }
}