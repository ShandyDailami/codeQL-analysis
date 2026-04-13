import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class java_34957_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the file: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        int lineCount = 0;

        try {
            lineCount = (int) file.length() / 100;
            if (file.length() % 100 != 0) {
                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("Invalid file path or permissions.");
            return;
        }

        System.out.println("The file contains " + lineCount + " lines.");
    }
}