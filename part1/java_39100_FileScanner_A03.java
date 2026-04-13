import java.io.File;
import java.util.Scanner;

public class java_39100_FileScanner_A03 {
    public static void main(String[] args) {
        File currentDir = new File(".");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Reading files in directory: " + directory.getAbsolutePath());
            for (File file : directory.listFiles()) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    System.out.println("Reading file: " + file.getAbsolutePath());
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                   
                    }
                    fileScanner.close();
                }
            }
        } else {
            System.out.println("Invalid directory or not a directory");
        }

        scanner.close();
    }
}