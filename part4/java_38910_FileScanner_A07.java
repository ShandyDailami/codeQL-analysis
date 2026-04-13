import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_38910_FileScanner_A07 {

    public static void main(String[] args) {
        File directory = new File(".");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        scanner.close();

        try {
            printFiles(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("Invalid directory path or no read permissions for the directory.");
        }
    }

    private static void printFiles(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFile(file);
                } else if (file.isDirectory()) {
                    printFiles(file);
                }
            }
        }
    }

    private static void printFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        System.out.println("\nContents of " + file.getName());
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        scanner.close();
    }
}