import java.io.File;
import java.util.Scanner;

public class java_39330_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.next();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        long length = file.length();

                        if (length <= 0) {
                            System.out.println("File: " + file.getName() + " is empty or doesn't exist.");
                        } else {
                            System.out.println("File: " + file.getName() + ", Length: " + length + " bytes");
                        }
                    }
                }
            } else {
                System.out.println("Directory is empty.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}