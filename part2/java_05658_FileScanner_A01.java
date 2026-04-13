import java.io.File;
import java.util.Scanner;

public class java_05658_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Files in the directory:");

            String[] fileNames = directory.list();

            for (String fileName : fileNames) {
                File file = new File(directoryPath + "/" + fileName);

                if (file.isFile() && file.canRead()) {
                    System.out.println(fileName);
                }
            }
        } else {
            System.out.println("The provided path is not a valid directory.");
        }
    }
}