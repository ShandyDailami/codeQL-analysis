import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37182_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "./src"; // This is the directory you want to scan

        File directory = new File(directoryPath);
        File[] directoryContents = directory.listFiles();

        if (directoryContents != null) {
            for (File file : directoryContents) {
                if (file.isFile()) {
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
}