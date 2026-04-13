import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13796_FileScanner_A03 {
    public static void main(String[] args) {
        String dir = "."; // Directory to scan
        String fileName = "test.txt";

        File file = new File(dir);

        try (Scanner scanner = new Scanner(file.getCanonicalFile())) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}