import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27586_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path

        File directory = new File(directoryPath);

        if (directory.exists()) {
            searchForTxtFiles(directory);
        } else {
            System.out.println("Directory does not exist!");
        }
    }

    private static void searchForTxtFiles(File directory) {
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null) {
            for (File file : files) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}