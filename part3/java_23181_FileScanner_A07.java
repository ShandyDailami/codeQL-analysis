import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_23181_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File directory = new File(".");
            File[] listOfFiles = directory.listFiles();
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}