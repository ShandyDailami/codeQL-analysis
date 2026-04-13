import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18904_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] allFiles = directory.listFiles();

            if (allFiles != null) {
                for (File file : allFiles) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            System.out.println("Content of file: " + file.getName());
                            while (scanner.hasNextLine()) {
                                System.out.println(scanner.nextLine());
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("Unable to read file: " + file.getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory not found: " + directoryPath);
        }
    }
}