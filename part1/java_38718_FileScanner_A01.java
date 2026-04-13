import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38718_FileScanner_A01 {

    public static void main(String[] args) {
        File directory = new File(".");
        String[] files = directory.list();

        if (files != null) {
            for (String file : files) {
                if (file.endsWith(".txt")) {
                    File txtFile = new File(file);
                    try (Scanner scanner = new Scanner(txtFile)) {
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