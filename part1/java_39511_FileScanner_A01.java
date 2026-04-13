import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39511_FileScanner_A01 {

    public static void main(String[] args) {
        File dir = new File("."); // The current directory
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                if (pathname.isFile() && pathname.getName().endsWith(".txt")) {
                    return true;
                }
                return false;
            }
        });

        if (files != null) {
            for (File file : files) {
                Scanner scanner = null;
                try {
                    scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    if (scanner != null) {
                        scanner.close();
                    }
                }
            }
        }
    }
}