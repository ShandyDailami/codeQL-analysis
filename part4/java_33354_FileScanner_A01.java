import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33354_FileScanner_A01 {

    public static void main(String[] args) {
        File directory = new File("./src/main/resources");
        String[] files = directory.list();

        if (files != null) {
            for (String file : files) {
                File fileObject = new File(directory.getAbsolutePath() + "/" + file);
                try (Scanner scanner = new Scanner(fileObject)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println("Line read from file: " + line);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found");
                }
            }
        }
    }
}