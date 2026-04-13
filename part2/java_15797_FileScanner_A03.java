import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15797_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        File file = new File(path);

        try {
            fileScanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public static void fileScanner(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            // Do something with line...
        }
        scanner.close();
    }
}