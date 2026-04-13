import java.io.File;
import java.util.Scanner;

public class java_04960_FileScanner_A08 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        FileScanner fileScanner = new FileScanner(file);
                        fileScanner.scanFile();
                        fileScanner.printResults();
                    }
                }
            } else {
                System.out.println("Directory is empty!");
            }
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }

}