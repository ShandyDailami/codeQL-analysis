import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23849_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // specify your directory here
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println(line);
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getPath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }
}