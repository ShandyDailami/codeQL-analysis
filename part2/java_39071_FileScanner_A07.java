import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39071_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        String searchString = "A07_AuthFailure";

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".java"));
        if (files != null) {
            for (File file : files) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains(searchString)) {
                        System.out.println("Found in file: " + file.getPath());
                    }
                }
                scanner.close();
            }
        }
    }
}