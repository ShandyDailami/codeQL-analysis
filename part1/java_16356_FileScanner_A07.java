import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16356_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\your_directory_path";
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // Here you can process the line, e.g., print it
                                System.out.println(line);
                           
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}