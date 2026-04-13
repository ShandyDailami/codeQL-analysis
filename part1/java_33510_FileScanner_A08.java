import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33510_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";
        String extension = ".txt";

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

            if (txtFiles != null) {
                for (File file : txtFiles) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getName());
                    }
                }
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("Directory not found: " + directoryPath);
        }
    }
}