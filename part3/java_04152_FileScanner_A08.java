import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_04152_FileScanner_A08 {
    private static final String targetFileExtension = ".txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the target file name:");
        String targetFileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(targetFileExtension);
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(targetFileName)) {
                    System.out.println("File found: " + file.getAbsolutePath());
                    return;
                }
            }
        }
        System.out.println("File not found!");
    }
}