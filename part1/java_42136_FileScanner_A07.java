import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_42136_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(System.in);
        System.out.println("Enter file path: ");
        String filePath = fileScanner.nextLine();
        File file = new File(filePath);

        if (file.exists()) {
            if (file.isFile()) {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
                fileScanner.close();
            } else {
                System.out.println("The provided path is not a file, not reading file.");
            }
        } else {
            System.out.println("The provided path does not exist, not reading file.");
        }
    }
}