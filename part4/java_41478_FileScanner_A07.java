import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41478_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // provide your directory path
        long maxFileSize = 100; // provide your maximum file size

        File directory = new File(directoryPath);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File file : txtFiles) {
                long fileSize = file.length();
                if (fileSize <= maxFileSize) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // perform security-sensitive operation here
                            System.out.println(line);
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}