import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15889_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the directory path:");
            String path = scanner.nextLine();

            File directory = new File(path);

            if (directory.exists()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                System.out.println(line);
                            }
                            fileScanner.close();
                        }
                    }
                }
            } else {
                System.out.println("Directory does not exist.");
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}