import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_19222_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (!file.isHidden() && file.isFile()) {
                        printFileContent(file);
                    }
                });
            } else {
                System.out.println("Given path is not a directory");
            }
        } else {
            System.out.println("Given path is not a directory");
        }

        scanner.close();
    }

    private static void printFileContent(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Failed to read file content: " + file.getPath());
        }
    }
}