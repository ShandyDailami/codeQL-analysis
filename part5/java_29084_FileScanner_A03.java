import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29084_FileScanner_A03 {

    public static void main(String[] args) {
        File directory = new File(".");
        String[] list = directory.list();

        for (String filename : list) {
            File file = new File(filename);
            if (file.isFile()) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + filename);
                }
            }
        }
    }
}