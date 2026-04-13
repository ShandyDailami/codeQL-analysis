import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class java_37394_FileScanner_A08 {
    private Set<String> safeDirectories;
    private Set<String> safeFiles;

    public java_37394_FileScanner_A08() {
        safeDirectories = new HashSet<>();
        safeFiles = new HashSet<>();

        // Adding directories and files that are safe here for the purpose of example
        safeDirectories.add("safe_directory1");
        safeDirectories.add("safe_directory2");

        safeFiles.add("safe_file1.txt");
        safeFiles.add("safe_file2.txt");
    }

    public void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();

                        if (safeFiles.contains(fileName)) {
                            System.out.println("Safe file: " + fileName);
                        } else {
                            System.out.println("Unsafe file: " + fileName);
                        }
                    } else if (file.isDirectory()) {
                        if (safeDirectories.contains(file.getName())) {
                            System.out.println("Safe directory: " + file.getName());
                        } else {
                            System.out.println("Unsafe directory: " + file.getName());
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SecurityFileScanner scanner = new SecurityFileScanner();
        scanner.scanDirectory("/path/to/directory");
    }
}