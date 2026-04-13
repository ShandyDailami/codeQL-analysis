import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_11920_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            System.exit(1);
        }

        List<String> filePaths = getFilePaths(directory);

        System.out.println("\nFile paths:");
        for (String filePath : filePaths) {
            System.out.println(filePath);
        }
    }

    private static List<String> getFilePaths(File directory) {
        List<String> filePaths = new ArrayList<>();
        File[] files = directory.listFiles();
        if (files == null) {
            return filePaths;
        }

        for (File file : files) {
            if (file.isFile()) {
                filePaths.add(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                filePaths.addAll(getFilePaths(file));
            }
        }

        return filePaths;
    }
}