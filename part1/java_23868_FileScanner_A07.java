import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_23868_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a directory:");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            List<File> files = new ArrayList<>(directory.listFiles());
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Invalid directory");
        }

        scanner.close();
    }
}