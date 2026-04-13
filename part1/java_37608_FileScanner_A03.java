import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37608_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File(".");
        String fileName = "example.txt";

        try {
            Scanner scanner = new Scanner(directory, "UTF-8");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("password")) {
                    System.out.println("Detected injection attempt!");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}