import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class java_19684_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);
        List<File> files = listFiles(directory);

        if (files.isEmpty()) {
            System.out.println("No files found in the directory.");
            return;
        }

        Collections.sort(files, (file1, file2) -> {
            if (file1.isDirectory() && !file2.isDirectory()) {
                return -1;
            } else if (file2.isDirectory() && !file1.isDirectory()) {
                return 1;
            } else {
                return file1.getName().compareTo(file2.getName());
            }
        });

        files.forEach(file -> System.out.println(file.getPath()));
    }

    private static List<File> listFiles(File directory) {
        List<File> files = new ArrayList<>();
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                files.addAll(listFiles(file));
            }
        }
        return files;
    }
}