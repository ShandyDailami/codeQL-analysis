import java.io.File;
import java.util.Scanner;

public class java_28636_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File name: " + file.getName());
                        System.out.println("File size: " + file.length() + " bytes");
                    }
                }
            }
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }
}