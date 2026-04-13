import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37395_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String extension = "txt";

        File directory = new File(directoryPath);

        if (directory.exists()) {
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
                System.out.println("No files with extension " + extension + " found in the directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}