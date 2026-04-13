import java.io.File;
import java.util.Scanner;

public class java_22180_FileScanner_A08 {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        File directory = new File(currentDir);
        File[] listOfFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.canRead()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                } else {
                    System.out.println("The file " + file.getName() + " cannot be read");
                }
            }
        }
    }
}