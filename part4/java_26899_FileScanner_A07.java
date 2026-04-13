import java.io.File;
import java.io.FilenameFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26899_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            FilenameFilter javaFilesFilter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".java");
                }
            };

            File[] javaFiles = directory.listFiles(javaFilesFilter);

            if (javaFiles != null) {
                for (File file : javaFiles) {
                    System.out.println("File name: " + file.getName());
                }
            } else {
                System.out.println("No Java files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory.");
        }
    }
}