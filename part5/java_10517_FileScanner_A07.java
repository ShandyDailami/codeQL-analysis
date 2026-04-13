import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_10517_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("The path is a directory: " + file.getAbsolutePath());
                File[] files = file.listFiles();
                if (files != null) {
                    Arrays.stream(files).forEach(f -> {
                        if (f.isFile() && f.getName().endsWith(".txt")) {
                            System.out.println("File Found: " + f.getAbsolutePath());
                        }
                    });
                } else {
                    System.out.println("No files in the directory");
                }
            } else {
                System.out.println("The path is not a directory");
            }
        } else {
            System.out.println("The directory does not exist");
        }
    }
}