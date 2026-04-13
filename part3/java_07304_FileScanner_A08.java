import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07304_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory"; // replace with your directory path

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // here you can process the line, e.g., print it
                                System.out.println(line);
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }
    }
}