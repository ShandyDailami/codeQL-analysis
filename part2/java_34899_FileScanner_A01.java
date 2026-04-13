import java.io.File;
import java.util.Scanner;

public class java_34899_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("File: " + file.getAbsolutePath());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getAbsolutePath());
                   
                        File[] nestedFiles = file.listFiles();

                        if (nestedFiles != null) {
                            for (File nestedFile : nestedFiles) {
                                if (nestedFile.isFile() && nestedFile.canRead()) {
                                    System.out.println("Nested file: " + nestedFile.getAbsolutePath());
                                } else if (nestedFile.isDirectory()) {
                                    System.out.println("Nested directory: " + nestedFile.getAbsolutePath());
                                }
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}