import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39413_FileScanner_A07 {

    public static void main(String[] args) {
        File directory = new File("path_to_directory");
        File[] foundFiles = directory.listFiles();

        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isFile()) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }
}