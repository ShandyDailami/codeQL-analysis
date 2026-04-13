import java.io.File;
import java.util.Scanner;

public class java_23430_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        String extension = fileName.substring(fileName.lastIndexOf("."));

                        if (extension.equalsIgnoreCase(".txt")) {
                            System.out.println("File name: " + fileName);
                            System.out.println("File size: " + file.length() + " bytes");
                            System.out.println("---");
                        }
                    }
                }
            } else {
                System.out.println("No files in the directory!");
            }
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }
}