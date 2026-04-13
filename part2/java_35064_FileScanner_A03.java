import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class java_35064_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("src/main/java/FileScanner.java");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}