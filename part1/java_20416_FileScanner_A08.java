import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_20416_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.next();
        System.out.println("Enter the file name(s): " + Arrays.toString(File.listRoots()));
        String fileName = scanner.next();

        File dir = new File(dirPath);
        if (dir.exists()) {
            File[] files = dir.listFiles((dir1, name) -> name.equals(fileName));
            if (files != null) {
                Arrays.stream(files).forEach(file -> System.out.println(file.getAbsolutePath()));
            } else {
                System.out.println("File not found in the directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
        scanner.close();
    }
}