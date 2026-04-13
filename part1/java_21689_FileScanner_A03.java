import java.io.File;
import java.util.Scanner;

public class java_21689_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println("File name: " + f.getName());
                }
            }
        } else {
            System.out.println("No files found in the directory");
        }
    }
}