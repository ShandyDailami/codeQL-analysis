import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_28568_FileScanner_A03 {

    private static final List<String> ALLOWED_EXTENSIONS = List.of("txt", "pdf", "docx", "csv", "xlsx");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            System.exit(1);
        }

        List<File> files = new ArrayList<>();
        retrieveFiles(directory, files);

        files.forEach(file -> {
            if (isFileAllowed(file.getName()) && isFileSafe(file)) {
                System.out.println("Found safe file: " + file.getAbsolutePath());
            }
        });
    }

    private static boolean isFileSafe(File file) {
        String name = file.getName();
        int lastDotIndex = name.lastIndexOf(".");
        if (lastDotIndex == -1) {
            return false;
        }

        String extension = name.substring(lastDotIndex + 1).toLowerCase();
        return ALLOWED_EXTENSIONS.contains(extension);
    }

    private static boolean isFileAllowed(String name) {
        int lastDotIndex = name.lastIndexOf(".");
        if (lastDotIndex == -1) {
            return false;
        }

        String extension = name.substring(lastDotIndex + 1).toLowerCase();
        return ALLOWED_EXTENSIONS.contains(extension);
    }

    private static void retrieveFiles(File dir, List<File> files) {
        File[] listOfFiles = dir.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && isFileSafe(file)) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    retrieveFiles(file, files);
                }
            }
        }
    }
}