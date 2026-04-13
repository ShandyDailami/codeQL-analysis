import java.io.File;
import java.util.Scanner;

public class java_28875_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.isDirectory()) {
            String[] fileList = directory.list();

            for (String fileName : fileList) {
                File file = new File(directory.getPath(), fileName);

                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        } else {
            System.out.println("Not a valid directory");
        }
    }
}