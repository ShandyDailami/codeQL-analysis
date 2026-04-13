import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39632_FileScanner_A07 {
    public static void main(String[] args) {
        String directory = "."; // Change this to your directory

        File file = new File(directory);
        if (file.exists()) {
            for (File item : file.listFiles()) {
                try (Scanner scanner = new Scanner(item)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("The specified file does not exist.");
        }
    }
}