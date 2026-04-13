import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17804_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your directory path
        String extension = ".txt";  // Replace with your file extension

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    try (Scanner scanner = new Scanner(txtFile)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("No txt files found in directory.");
            }
        } else {
            System.out.println("Given path is not a directory.");
        }
    }
}