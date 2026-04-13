import java.io.File;
import java.util.Scanner;

public class java_03839_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] listOfFiles = directory.listFiles();

            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        System.out.println(file.getAbsolutePath());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files or directories found in the directory.");
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }

        scanner.close();
    }
}