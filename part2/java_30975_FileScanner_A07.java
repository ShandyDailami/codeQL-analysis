import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30975_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your directory path
        File directory = new File(directoryPath);
        
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println(line);
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getAbsolutePath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or is not a directory: " + directoryPath);
        }
    }
}