import java.io.File;
import java.util.Scanner;

public class java_13617_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the directory:");
        String path = scanner.nextLine();
        File directory = new File(path);

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        // This is a dummy operation, replace with actual security-sensitive operations
                        file.setReadable(false, false);
                        file.setWritable(false, false);
                        file.setExecutable(false, false);
                    } catch (SecurityException e) {
                        System.out.println("Error setting permissions for file: " + file.getName());
                    }
                }
            }
        }

        scanner.close();
    }
}