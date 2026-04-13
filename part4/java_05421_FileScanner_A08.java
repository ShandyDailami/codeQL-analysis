import java.io.File;
import java.util.Scanner;

public class java_05421_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        System.out.println("Please enter the file name:");
        String fileName = scanner.nextLine();

        File file = new File(directory, fileName);

        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        try {
            System.out.println("Reading file...");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            fileScanner.close();

            System.out.println("File reading completed successfully!");
        } catch (Exception e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
    }
}