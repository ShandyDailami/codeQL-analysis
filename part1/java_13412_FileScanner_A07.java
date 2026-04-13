import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13412_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        String fileExtension = "txt";  // replace with your file extension
        String fileNamePattern = "fileNamePattern";  // replace with your file name pattern

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                if (file.getName().matches(fileNamePattern)) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                }
            }
        } else {
            System.out.println("Directory is empty or does not exist.");
        }
    }
}