import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02177_FileScanner_A01 {

    public static void main(String[] args) {
        // create a file scanner to scan files in the directory
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        try {
            // create a file scanner to scan files in the directory
            File directory = new File(directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // check if the file is a text file
                        if (file.getName().endsWith(".txt")) {
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                System.out.println(line);
                            }
                            fileScanner.close();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}