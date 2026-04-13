import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_19896_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the file:");
        String filePath = scanner.nextLine();
        scanner.close();

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        if (!file.canRead()) {
            System.out.println("You do not have permission to read the file!");
            return;
        }

        try {
            FileScanner fileScanner = new FileScanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.contains("A07_AuthFailure")) {
                    System.out.println("Line contains 'A07_AuthFailure': " + line);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}