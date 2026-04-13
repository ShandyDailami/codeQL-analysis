import java.io.File;
import java.util.Scanner;

public class java_15061_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file extension: ");
        String extension = scanner.next();

        String dirPath = ".";

        searchForFile(new File(dirPath), extension);
    }

    private static void searchForFile(File directory, String extension) {
        for (File file : directory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(extension)) {
                System.out.println("File found: " + file.getAbsolutePath());
            } else if (file.isDirectory()) {
                searchForFile(file, extension);
            }
        }
    }
}