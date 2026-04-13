import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14228_FileScanner_A08 {
    public static void main(String[] args) {
        String currentDirectory = new File(".").getAbsolutePath();
        searchTextFiles(new File(currentDirectory));
    }

    public static void searchTextFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                       
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (file.isDirectory()) {
                    searchTextFiles(file);
                }
            }
        }
    }
}