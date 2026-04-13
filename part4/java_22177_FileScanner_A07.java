import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_22177_FileScanner_A07 {

    private String directoryPath;
    private String extension;

    public java_22177_FileScanner_A07(String directoryPath, String extension) {
        this.directoryPath = directoryPath;
        this.extension = extension;
    }

    public List<File> getFiles() {
        File directory = new File(directoryPath);
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith(extension);
            }
        };
        List<File> files = new ArrayList<>();
        directory.listFiles(filter);
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                files.add(file);
            }
        }
        return files;
    }

    public void printFiles() {
        List<File> files = getFiles();
        for (File file : files) {
            System.out.println("File: " + file.getAbsolutePath());
            System.out.println("Size: " + file.length() + " bytes");
            System.out.println("------------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the extension:");
        String extension = scanner.nextLine();
        FileScanner fileScanner = new FileScanner(directoryPath, extension);
        fileScanner.printFiles();
    }
}