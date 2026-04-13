import java.io.File;
import java.util.Scanner;

public class java_36021_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String path = scanner.nextLine();
        scanner.close();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.getName().endsWith(".txt")) {
                            System.out.println("File name: " + file.getName());
                            System.out.println("File size: " + file.length() + " bytes");
                        }
                    }
                }
            } else {
                System.out.println("No files in directory!");
            }
        } else {
            System.out.println("Directory does not exist!");
        }
    }
}