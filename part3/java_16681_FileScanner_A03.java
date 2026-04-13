import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16681_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Enter the directory path:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }
}