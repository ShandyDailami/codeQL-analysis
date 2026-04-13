import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34981_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "your_directory_path_here";
        String extension = "your_file_extension_here";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No files with extension " + extension + " in directory " + directoryPath);
        }
    }
}