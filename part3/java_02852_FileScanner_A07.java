import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02852_FileScanner_A07 {
    public static void main(String[] args) {
        String directory = "/path/to/directory";  // Change this to your directory
        String extension = "txt";  // Change this to your file extension
        String sensitiveOperation = "AuthFailure";  // Change this to your sensitive operation

        File dir = new File(directory);

        if (dir.isDirectory()) {
            File[] files = dir.listFiles((dir2, name) -> name.endsWith(extension));

            if (files != null) {
                for (File file : files) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains(sensitiveOperation)) {
                                System.out.println("Found sensitive operation in file: " + file.getName());
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}