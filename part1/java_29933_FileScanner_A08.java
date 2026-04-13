import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29933_FileScanner_A08 {

    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");

        File dir = new File(currentDir);

        File[] secureFiles = dir.listFiles((File pathname) -> {
            return pathname.isFile() && pathname.getName().endsWith(".txt") && pathname.length() > 100;
        });

        if (secureFiles != null) {
            for (File file : secureFiles) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}