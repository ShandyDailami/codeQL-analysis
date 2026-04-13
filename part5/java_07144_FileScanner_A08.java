import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07144_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        String[] list = directory.list();
        for (String filename : list) {
            File file = new File(filename);
            if (file.isFile() && file.canRead()) {
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