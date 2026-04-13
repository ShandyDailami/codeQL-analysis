import java.io.File;
import java.util.Scanner;

public class java_13994_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            System.out.println("Please enter the directory path:");
            Scanner scanner = new Scanner(System.in);
            String directoryPath = scanner.nextLine();
            scanner.close();

            File directory = new File(directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("Reading file: " + file.getAbsolutePath());
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
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}