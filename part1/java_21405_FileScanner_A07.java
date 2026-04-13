import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21405_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] files = directory.list(new MyFileFilter());

        for (String fileName : files) {
            File file = new File(fileName);

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line.substring(0, Math.min(line.length(), 50)));
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + fileName);
            }
        }
    }
}

class MyFileFilter implements java.io.FilenameFilter {
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(".txt");
    }
}