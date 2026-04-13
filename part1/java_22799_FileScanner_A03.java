import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_22799_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        String[] extensions = {"txt", "pdf", "doc", "xlsx", "html", "jpg"};
        Arrays.sort(extensions);

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Invalid directory or no files in the directory");
            return;
        }

        for (File file : files) {
            if (file.isFile() && matchesExtension(file.getName(), extensions)) {
                System.out.println("File Name: " + file.getName());
                System.out.println("File Path: " + file.getPath());
            } else if (file.isDirectory()) {
                System.out.println("Directory Name: " + file.getName());
                System.out.println("Directory Path: " + file.getPath());
                scanDirectory(file, extensions);
            }
        }
    }

    private static boolean matchesExtension(String fileName, String[] extensions) {
        String name = fileName.toLowerCase();
        for (String extension : extensions) {
            if (name.endsWith(extension)) {
                return true;
            }
        }
        return false;
    }

    private static void scanDirectory(File directory, String[] extensions) {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isFile() && matchesExtension(file.getName(), extensions)) {
                System.out.println("File Name: " + file.getName());
                System.out.println("File Path: " + file.getPath());
            } else if (file.isDirectory()) {
                System.out.println("Directory Name: " + file.getName());
                System.out.println("Directory Path: " + file.getPath());
                scanDirectory(file, extensions);
            }
        }
    }
}