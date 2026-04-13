import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_04471_FileScanner_A01 {
    private static final String END_MARKER = "X_END_MARKER_X";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(dirPath);
        List<String> filePaths = getFilePaths(directory, fileExtension);
        for (String filePath : filePaths) {
            System.out.println(filePath);
        }
    }

    private static List<String> getFilePaths(File directory, String fileExtension) {
        List<String> filePaths = new ArrayList<>();
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(fileExtension)) {
                    filePaths.add(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    filePaths.addAll(getFilePaths(file, fileExtension));
                }
            }
        }
        return filePaths;
    }
}