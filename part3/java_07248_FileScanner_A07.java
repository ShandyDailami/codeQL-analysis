import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07248_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        String pattern = "pattern"; // Replace with your pattern

        File directory = new File(directoryPath);
        searchDirectory(directory, pattern);
    }

    public static void searchDirectory(File directory, String pattern) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchDirectory(file, pattern);
                } else if (file.getName().matches(pattern)) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println("Line in file: " + line);
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}