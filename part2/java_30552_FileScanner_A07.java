import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30552_FileScanner_A07 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with your directory path

        File dir = new File(dirPath);
        File[] hiddenFiles = dir.listFiles(file -> file.isHidden() && (file.getName().endsWith(".txt") || file.getName().endsWith(".log")));

        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                Scanner scanner = null;
                try {
                    scanner = new Scanner(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Implement your security-sensitive operation here.
                    // For now, we will just print the line.
                    System.out.println(line);
                }

                scanner.close();
            }
        }
    }
}