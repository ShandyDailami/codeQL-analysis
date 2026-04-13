import java.io.File;
import java.util.Scanner;

public class java_34776_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.canRead() && file.canWrite()) {
                        System.out.println("File: " + file.getName() + ", readable: " + file.canRead() + ", writable: " + file.canWrite());
                    } else {
                        System.out.println("File: " + file.getName() + ", readable: " + file.canRead() + ", writable: " + file.canWrite() + ", Not Allowed");
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist");
        }

        scanner.close();
    }
}