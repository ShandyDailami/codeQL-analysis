import java.io.File;
import java.util.Scanner;

public class java_26519_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isFile()) {
                if (file.canRead()) {
                    System.out.println("Reading the file...");
                    readFile(file);
                } else {
                    System.out.println("You do not have permission to read the file.");
                }
            } else {
                System.out.println("The provided path is not a file.");
            }
        } else {
            System.out.println("The file does not exist.");
        }

        scanner.close();
    }

    private static void readFile(File file) {
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}