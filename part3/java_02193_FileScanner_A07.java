import java.io.File;
import java.util.Scanner;

public class java_02193_FileScanner_A07 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // Replace with your directory path
        String extension = ".txt";

        File dir = new File(dirPath);
        File[] txtFiles = dir.listFiles((dir1, name) -> name.endsWith(extension));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                Scanner scanner = new Scanner(txtFile);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }

                scanner.close();
            }
        }
    }
}