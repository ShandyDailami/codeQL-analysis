import java.io.File;
import java.util.Scanner;

public class java_37409_FileScanner_A07 {
    public static void main(String[] args) {
        String dirPath = "/path/to/dir"; // Replace with your directory path

        File dir = new File(dirPath);
        File[] files = dir.listFiles((dir2, name) -> name.endsWith(".txt"));

        if (files != null) {
            for (File file : files) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
                scanner.close();
            }
        }
    }
}