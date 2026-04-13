import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_02682_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter file name:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().equals(fileName);
            }
        });

        if (files.length > 0) {
            System.out.println("File found in directory: " + files[0].getAbsolutePath());
        } else {
            System.out.println("File not found in directory");
        }
    }
}