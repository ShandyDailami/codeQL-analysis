import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04611_FileScanner_A07 {
    public static void main(String[] args) {
        String path = "."; // Current directory
        searchFile(path);
    }

    public static void searchFile(String path) {
        File dir = new File(path);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchFile(file.getPath());
                } else if (file.getName().equals("auth_failure.log")) {
                    Scanner scanner = null;
                    try {
                        scanner = new Scanner(file);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains("auth_failure")) {
                            System.out.println(line);
                        }
                    }
                    scanner.close();
                }
            }
        }
    }
}