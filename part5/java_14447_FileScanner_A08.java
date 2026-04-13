import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14447_FileScanner_A08 {

    public static void main(String[] args) {
        File file = new File("target/A08_IntegrityFailure.txt");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (checkFileIntegrity(line)) {
                    System.out.println("File integrity check failed for: " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }

    private static boolean checkFileIntegrity(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.length() != file.getTotalSpace() || file.delete();
    }
}