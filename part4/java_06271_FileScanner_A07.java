import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06271_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with actual path
        String fileName = "A07_AuthFailure.txt"; // replace with actual file name

        File directory = new File(directoryPath);

        File[] files = directory.listFiles((dir, name) -> name.equals(fileName));

        if (files.length > 0) {
            try (Scanner scanner = new Scanner(files[0])) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        } else {
            System.out.println("File not found in the directory");
        }
    }
}