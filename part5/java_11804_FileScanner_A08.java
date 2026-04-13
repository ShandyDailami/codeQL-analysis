import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_11804_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try {
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                // Do something with the line (e.g., print or check for integrity)
                                System.out.println(line);
                           
                            }
                            fileScanner.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getPath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + dirPath);
        }

        scanner.close();
    }
}