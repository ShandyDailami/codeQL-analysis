import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41696_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Files in directory:");

            try (FileScanner scanner = new FileScanner()) {
                for (File file : dir.listFiles()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }
}