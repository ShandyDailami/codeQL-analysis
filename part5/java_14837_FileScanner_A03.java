import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14837_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                try (Scanner scanner = new Scanner(txtFile)) {
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}