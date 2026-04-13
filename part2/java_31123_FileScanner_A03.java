import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_31123_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        try {
            File file = new File(filePath);
            if (file.exists()) {
                if (file.isFile()) {
                    if (file.canRead()) {
                        scannerFile(file);
                    } else {
                        System.out.println("The file cannot be read.");
                    }
                } else {
                    System.out.println("The given path does not point to a file.");
                }
            } else {
                System.out.println("The file does not exist.");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public static void scannerFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}