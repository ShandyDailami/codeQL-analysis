import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06074_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the directory:");
        String dirPath = scanner.nextLine();

        try {
            File dir = new File(dirPath);
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                        // Here you can perform security-sensitive operations related to A03_Injection
                        // for example, reading the file content and print it to the console
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println(line);
                        }
                        fileScanner.close();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}