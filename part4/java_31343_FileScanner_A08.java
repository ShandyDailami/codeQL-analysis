import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31343_FileScanner_A08 {

    public static void main(String[] args) {

        String directoryPath = "/path/to/your/directory"; // Replace with your directory path
        String filePattern = "file*.txt"; // Replace with your file pattern

        File directory = new File(directoryPath);

        File[] matchingFiles = directory.listFiles((dir, name) -> name.matches(filePattern));

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}