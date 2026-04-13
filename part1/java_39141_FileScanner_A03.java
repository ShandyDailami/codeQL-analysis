import java.io.File;
import java.util.Scanner;

public class java_39141_FileScanner_A03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.next();
        scanner.close();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Files in the directory:");
                String[] files = file.list();

                for (String fileName : files) {
                    System.out.println(fileName);
                }
            } else {
                System.out.println("The path is not a directory.");
            }
        } else {
            System.out.println("The directory does not exist.");
        }
    }
}