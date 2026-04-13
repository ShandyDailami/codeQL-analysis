import java.io.File;
import java.util.Scanner;

public class java_01269_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        File directory = new File(path);

        if (directory.isDirectory()) {
            System.out.println("Files in the directory:");
            File[] files = directory.listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("The provided path is not a directory.");
        }
    }
}