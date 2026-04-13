import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class java_26898_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File dir = new File(path);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.canWrite()) {
                    System.out.println(file.getAbsolutePath());
                } else {
                    throw new SecurityException("Cannot write to file: " + file.getAbsolutePath());
                }
            }
        }

        scanner.close();
    }
}