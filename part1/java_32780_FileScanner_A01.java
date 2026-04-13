import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32780_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            fileScan(directory);
        } else {
            System.out.println("Directory not found");
        }
    }

    private static void fileScan(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    scanFile(file);
                } else if (file.isDirectory()) {
                    fileScan(file);
                }
            }
        }
    }

    private static void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}