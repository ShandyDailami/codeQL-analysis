import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_05158_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the extensions (comma separated):");
        String extensions = scanner.nextLine();

        File directory = new File(directoryPath);
        List<File> files = new ArrayList<>();

        // Search for all files in the directory and its subdirectories
        searchFiles(directory, files, extensions.split(","));

        // Print the names of the files
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    private static void searchFiles(File directory, List<File> files, String[] extensions) {
        File[] filesInDirectory = directory.listFiles();

        if (filesInDirectory != null) {
            for (File file : filesInDirectory) {
                if (file.isDirectory()) {
                    // Recursively search the subdirectory
                    searchFiles(file, files, extensions);
                } else {
                    String name = file.getName();
                    boolean isValid = false;

                    // Check if the file is a valid file and has the required extension
                    for (String ext : extensions) {
                        if (name.endsWith(ext)) {
                            isValid = true;
                            break;
                        }
                    }

                    if (isValid) {
                        files.add(file);
                    }
                }
            }
        }
    }
}