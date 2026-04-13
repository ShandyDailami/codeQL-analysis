import java.io.File;
import java.util.Scanner;

public class java_25370_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        printFileContents(file);
                    }
                }
            }
        } else {
            System.out.println("The directory does not exist.");
        }

        scanner.close();
    }

    private static void printFileContents(File file) {
        if (file.canRead()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } else {
            System.out.println("Cannot read file: " + file.getPath());
        }
    }
}