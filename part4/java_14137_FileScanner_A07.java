import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14137_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "YourDirectoryPath"; // replace with your directory path
        String extension = "YourExtension"; // replace with your extension

        File directory = new File(directoryPath);

        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line); // replace with your security-sensitive operation
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}