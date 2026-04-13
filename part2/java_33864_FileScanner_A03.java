import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33864_FileScanner_A03 {

    public static void main(String[] args) {
        File directory = new File(".");
        String fileType = "txt"; // Specify your file type here

        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileType));

        if (files != null) {
            for (File file : files) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line); // Print the line to console
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}