import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22162_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("filename.txt"); // replace with your file path
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("A08_IntegrityFailure")) {
                    System.out.println("File name: " + file.getName());
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}