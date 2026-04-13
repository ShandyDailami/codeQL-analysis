import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_08147_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();

        File dir = new File(dirPath);
        FilenameFilter filter = (dir1, name) -> name.endsWith(fileName);

        File[] files = dir.listFiles(filter);
        if (files == null) {
            System.out.println("No files found!");
            return;
        }

        System.out.println("Files in directory " + dirPath + " with name ending with \"" + fileName + "\":");
        for (File file : files) {
            System.out.println(file.getName());
        }

        scanner.close();
    }
}