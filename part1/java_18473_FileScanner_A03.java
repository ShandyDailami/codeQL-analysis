import java.io.File;
import java.util.Scanner;

public class java_18473_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileContent(file);
                }
           
                if (file.isDirectory()) {
                    printDirectoryContent(file);
                }
            }
        }
    }

    private static void printFileContent(File file) {
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println("File Content: " + line);
            }
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error occurred while reading file: " + file.getPath());
        }
    }

    private static void printDirectoryContent(File file) {
        try {
            Scanner directoryScanner = new Scanner(file.listFiles()[0].getCanonicalPath());
            while (directoryScanner.hasNextLine()) {
                String line = directoryScanner.nextLine();
                System.out.println("Directory Content: " + line);
            }
            directoryScanner.close();
        } catch (Exception e) {
            System.out.println("Error occurred while reading directory: " + file.getPath());
        }
    }
}