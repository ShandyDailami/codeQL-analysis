import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04172_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            if (line.contains("A07_AuthFailure")) {
                System.out.println("Detected A07_AuthFailure error: " + line);
            }
        }
        fileScanner.close();
    }
}