import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_12312_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                Arrays.stream(files)
                      .filter(file -> file.isFile() && file.getName().endsWith(".txt"))
                      .forEach(file -> readAndPrintFileContent(file));
            }
        } else {
            System.out.println("Directory does not exist or it is not a directory.");
        }

        scanner.close();
    }

    private static void readAndPrintFileContent(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getPath());
        }
    }
}