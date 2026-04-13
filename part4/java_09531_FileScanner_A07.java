import java.io.File;
import java.util.Scanner;

public class java_09531_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println(file.getAbsolutePath());
                        }
                    }
                }
            } else {
                System.out.println("Entered path is not a directory.");
            }
        } else {
            System.out.println("Entered path does not exist.");
        }
    }
}