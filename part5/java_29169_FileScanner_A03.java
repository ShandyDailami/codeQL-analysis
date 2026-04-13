import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29169_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "your_directory_path_here"; // replace with your directory path
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.canRead()) {
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