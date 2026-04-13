import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_27671_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        try {
            File file = new File(filePath);
            if (file.exists()) {
                scannerFile(file);
            } else {
                System.out.println("File not found!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } finally {
            scanner.close();
        }
    }

    private static void scannerFile(File file) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }
        fileScanner.close();
    }
}