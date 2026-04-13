import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_31173_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = input.nextLine();

        try {
            File file = new File(filePath);
            if (file.exists()) {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
                fileScanner.close();
            } else {
                System.out.println("File not found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}