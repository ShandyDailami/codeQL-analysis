import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_04565_FileScanner_A03 {

    private static final String[] EXTENSIONS_TO_SEARCH = {"txt", "java", "class", "js", "html", "css", "json"};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.stream(files)
                        .filter(file -> file.isFile() && isFileFromSensitiveExtensions(file.getName()))
                        .forEach(file -> printFileContent(file));
            }
        } else {
            System.out.println("Directory not found!");
        }
    }

    private static boolean isFileFromSensitiveExtensions(String fileName) {
        return Arrays.stream(EXTENSIONS_TO_SEARCH)
                .anyMatch(fileName::endsWith);
    }

    private static void printFileContent(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error occurred while reading file: " + file.getPath());
        }
    }
}