import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class java_40828_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the file path: ");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        scanner.close();

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        Scanner fileScanner = new Scanner(file);

        int lineNumber = 0;
        while (fileScanner.hasNextLine()) {
            lineNumber++;
            String line = fileScanner.nextLine();
            System.out.println("Line " + lineNumber + ": " + line);
        }

        fileScanner.close();
    }
}