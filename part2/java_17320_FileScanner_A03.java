import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17320_FileScanner_A03 {

    public static void main(String[] args) {
        File directory = new File(".");
        String[] files = directory.list();

        if (files != null) {
            for (String file : files) {
                File fileObj = new File(file);
                if (fileObj.isFile() && fileObj.canRead()) {
                    try (Scanner scanner = new Scanner(fileObj)) {
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
}