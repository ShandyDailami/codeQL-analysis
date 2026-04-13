import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20242_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "src/main/resources"; // replace with your directory path
        File directory = new File(directoryPath);
        File[] directoryFiles = directory.listFiles();

        if (directoryFiles != null) {
            for (File file : directoryFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    readFile(file);
                }
            }
        }
    }

    private static void readFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}