import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_06367_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        List<File> files = listFilesRecursively(directory);

        for (File file : files) {
            System.out.println(file.getPath());
        }
    }

    private static List<File> listFilesRecursively(File directory) {
        List<File> files = new ArrayList<>();
        File[] foundFiles = directory.listFiles();

        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isFile()) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    files.addAll(listFilesRecursively(file));
                }
            }
        }
        return files;
    }
}