import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22908_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        File currentDir = new File(".");

        String searchTerm = "password";

        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().contains(searchTerm);
            }
        };

        File[] files = currentDir.listFiles(filter);

        if (files != null) {
            for (File file : files) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains(searchTerm)) {
                        System.out.println("File: " + file.getAbsolutePath() + " contains: " + searchTerm);
                    }
                }
                scanner.close();
            }
        }
    }
}