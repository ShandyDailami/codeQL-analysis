import java.io.File;
import java.util.Scanner;

public class java_15671_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File file = new File(directoryPath);

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        if (f.isFile() && f.getName().endsWith(".txt")) {
                            System.out.println("File Name: " + f.getName());
                            System.out.println("Absolute Path: " + f.getAbsolutePath());
                            System.out.println("-----------------------");
                        }
                    }
                }
            } else {
                System.out.println("Given path does not exist or it's not a directory.");
            }
        } else {
            System.out.println("Given path does not exist or it's not accessible.");
        }

        scanner.close();
    }
}