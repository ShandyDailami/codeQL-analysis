import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36562_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.canRead()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println(line);
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("Error reading file: " + file.getName());
                        }
                    } else {
                        System.out.println("Permission denied for file: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }
}