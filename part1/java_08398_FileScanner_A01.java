import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08398_FileScanner_A01 {
    public static void main(String[] args) {
        // Path to the directory you want to scan
        String directoryPath = "/path/to/your/directory";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String fileContent = scanner.nextLine();
                            System.out.println("File Content: " + fileContent);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}