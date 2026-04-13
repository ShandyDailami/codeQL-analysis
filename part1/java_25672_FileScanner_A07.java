import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25672_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String fileName = "AuthFailure";

        File directory = new File(directoryPath);

        File[] files = directory.listFiles((dir, name) -> name.contains(fileName));

        if (files != null) {
            for (File file : files) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
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