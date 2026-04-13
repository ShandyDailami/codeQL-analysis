import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01659_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";

        File directory = new File(directoryPath);

        File[] allFiles = directory.listFiles();

        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile()) {
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
                }
            }
        }
    }
}