import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_08421_FileScanner_A01 {
    private File directory;
    private List<File> files;

    public java_08421_FileScanner_A01(String directoryPath) {
        directory = new File(directoryPath);
        files = new ArrayList<>();
        scanDirectory(directory);
    }

    private void scanDirectory(File directory) {
        File[] foundFiles = directory.listFiles();
        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".txt")) {
                        files.add(file);
                    }
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }

    public List<File> getFiles() {
        return files;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        FileScanner scannerInstance = new FileScanner(directoryPath);
        for (File file : scannerInstance.getFiles()) {
            System.out.println(file.getAbsolutePath());
        }
        scanner.close();
    }
}