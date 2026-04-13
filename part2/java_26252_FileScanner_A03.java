import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_26252_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File dir = new File(path);

        if (dir.exists()) {
            File[] listFiles = dir.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.isFile()) {
                        System.out.println("File name: " + file.getName());
                    } else {
                        System.out.println("Directory name: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }

        scanner.close();
    }
}