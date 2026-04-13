import java.io.File;
import java.util.Scanner;

public class java_20009_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File directory = new File(dirPath);
        File[] listOfFiles = directory.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}