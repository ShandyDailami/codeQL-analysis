import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_40599_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);

        System.out.println("Enter the file name:");
        String fileName = scanner.next();

        File file = new File(directory, fileName);

        try {
            if (!file.exists()) {
                System.out.println("File not found!");
                return;
            }

            if (!file.canRead()) {
                System.out.println("Cannot read file!");
                return;
            }

            if (!file.isFile()) {
                System.out.println("Not a file!");
                return;
            }

            if (!file.getName().endsWith(".txt")) {
                System.out.println("File is not a text file!");
                return;
            }

            System.out.println("Reading file: " + file.getPath());
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}