import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20540_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the file:");
        String filePath = scanner.nextLine();
        scanner.close();

        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("File exists.");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line); // Printing each line of the file
            }
            fileScanner.close();
        } else {
            System.out.println("File does not exist.");
        }
    }
}