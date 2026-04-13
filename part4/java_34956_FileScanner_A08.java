import java.io.File;
import java.util.Scanner;

public class java_34956_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.next();
        scanner.close();

        File dir = new File(path);
        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("File Name: " + file.getName());
                        System.out.println("Absolute path: " + file.getAbsolutePath());
                        System.out.println("Readable: " + file.canRead());
                        System.out.println("Writable: " + file.canWrite());
                        System.out.println("Executable: " + file.canExecute());
                        System.out.println("---------------------");
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}