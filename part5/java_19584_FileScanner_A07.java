import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19584_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] list = directory.list();

        if (list == null) {
            System.out.println("No files found!");
            return;
        }

        for (String filename : list) {
            File file = new File(filename);

            if (!file.isFile()) {
                continue;
            }

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + file.getPath());
            }
        }
    }
}