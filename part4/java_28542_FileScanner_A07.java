import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_28542_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith("." + fileExtension);
            }
        };

        File[] matchingFiles = directory.listFiles(filter);

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                System.out.println("Matching file: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with the specified extension!");
        }
    }
}