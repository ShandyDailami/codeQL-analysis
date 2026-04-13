import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02444_FileScanner_A03 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            File file = new File(filePath);

            if (file.exists()) {
                if (file.canRead()) {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        // Security sensitive operation here
                        System.out.println(line);
                    }
                    fileScanner.close();
                } else {
                    System.out.println("The file cannot be read.");
                }
            } else {
                System.out.println("The file does not exist.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}