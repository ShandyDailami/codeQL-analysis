import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16724_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the file path:");
        String filePath = scanner.nextLine();
        scanner.close();

        File file = new File(filePath);

        if (file.exists()) {
            if (file.isFile()) {
                if (file.canRead()) {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }
                    fileScanner.close();
                } else {
                    System.out.println("The file cannot be read. Check permissions.");
                }
            } else {
                System.out.println("The provided path does not point to a file.");
            }
        } else {
            System.out.println("The file does not exist.");
        }
    }
}