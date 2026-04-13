import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16009_FileScanner_A07 {
    private static File file;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file path: ");
        String path = scanner.nextLine();

        file = new File(path);

        if (file.exists()) {
            handleFile(file);
        } else {
            System.out.println("File not found!");
        }

        scanner.close();
    }

    private static void handleFile(File file) {
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}