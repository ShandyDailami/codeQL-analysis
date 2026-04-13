import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_06262_FileScanner_A01 {

    private static final String ROOT_DIR = "C:\\"; // replace with your root directory
    private static final String FILE_EXTENSION = ".*\\.txt"; // replace with your file extension

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter file extension:");
        String fileExtension = scanner.nextLine();

        File rootDir = new File(ROOT_DIR);
        File[] files = rootDir.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            Arrays.stream(files)
                    .filter(file -> file.isFile() && file.canRead())
                    .forEach(file -> printFileContent(file));
        } else {
            System.out.println("No files found with the provided extension.");
        }

        scanner.close();
    }

    private static void printFileContent(File file) {
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getAbsolutePath());
        }
    }
}