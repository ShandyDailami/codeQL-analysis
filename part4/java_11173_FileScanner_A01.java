import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_11173_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        List<File> files = new ArrayList<>();
        getFilesWithExtension(directory, fileExtension, files);

        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private static void getFilesWithExtension(File directory, String extension, List<File> files) {
        File[] directoryContents = directory.listFiles();
        if (directoryContents != null) {
            for (File file : directoryContents) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    getFilesWithExtension(file, extension, files);
                }
            }
        }
    }
}