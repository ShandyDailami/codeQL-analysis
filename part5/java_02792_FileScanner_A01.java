import java.io.File;
import java.util.Scanner;

public class java_02792_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        System.out.println("File name: " + file.getName());
                        System.out.println("File size: " + file.length() + " bytes");
                    }
                }
            } else {
                System.out.println("No files in directory " + directoryPath);
            }
        } else {
            System.out.println("Directory " + directoryPath + " does not exist");
        }
    }
}