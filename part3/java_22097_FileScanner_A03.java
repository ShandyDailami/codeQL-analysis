import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22097_FileScanner_A03 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with your directory path

        File directory = new File(dirPath);

        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
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
        }
    }
}