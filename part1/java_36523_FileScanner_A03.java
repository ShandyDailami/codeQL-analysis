import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36523_FileScanner_A03 {
    private static int fileCount = 0;
    private static String filePath;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the directory to search:");
        filePath = scanner.nextLine();

        searchDirectory(new File(filePath));
        System.out.println("Number of files: " + fileCount);
    }

    private static void searchDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchDirectory(file);
                } else if (file.getName().equals("YourFile.txt")) {
                    fileCount++;
                }
            }
        }
    }
}