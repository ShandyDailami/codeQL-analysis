import java.io.File;
import java.util.Scanner;

public class java_19410_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            String[] files = directory.list();
            if (files != null) {
                for (String fileName : files) {
                    File file = new File(directoryPath + "/" + fileName);
                    if (file.exists() && !file.isDirectory()) {
                        System.out.println("File name: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files found in directory.");
            }
        } else {
            System.out.println("Invalid directory.");
        }
    }
}