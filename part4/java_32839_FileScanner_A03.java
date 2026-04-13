import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_32839_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String path = scanner.nextLine();
        File directory = new File(path);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try {
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                System.out.println(line);
                            }
                            fileScanner.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory not found: " + path);
        }
        scanner.close();
    }
}