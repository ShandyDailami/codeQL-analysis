import java.io.File;
import java.util.Scanner;

public class java_34919_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            fileScanner(directory, "");
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }

        scanner.close();
    }

    private static void fileScanner(File directory, String indentation) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    fileScanner(file, indentation + "  ");
                } else {
                    printFileInfo(file, indentation);
                }
            }
        }
    }

    private static void printFileInfo(File file, String indentation) {
        System.out.println(indentation + "- " + file.getName());

        if (file.getName().contains("A08_IntegrityFailure")) {
            System.out.println("WARNING: File contains sensitive information: " + file.getAbsolutePath());
        }
    }
}