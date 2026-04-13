import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01047_FileScanner_A01 {
    private static final String DIRECTORY = "/path/to/directory"; // replace with your directory

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(DIRECTORY);
        Scanner scanner = new Scanner(System.in);
        String filePath = "";

        System.out.println("Enter the file path (or 'exit' to quit):");
        filePath = scanner.nextLine();

        while (!filePath.equals("exit")) {
            File file = new File(directory, filePath);

            if (file.exists()) {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
                fileScanner.close();
            } else {
                System.out.println("File not found: " + filePath);
            }

            System.out.println("Enter the file path (or 'exit' to quit):");
            filePath = scanner.nextLine();
        }

        scanner.close();
    }
}