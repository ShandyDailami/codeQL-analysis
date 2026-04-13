import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01773_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File("./");
        String extension = ".txt";
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                try {
                    Scanner scanner = new Scanner(txtFile);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + txtFile.getName());
                }
            }
        } else {
            System.out.println("No text files found in: " + directory.getAbsolutePath());
        }
    }
}