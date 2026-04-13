import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27010_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // specify your directory path here
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files in directory");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                readFile(file);
            }
        }
    }

    public static void readFile(File file) {
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