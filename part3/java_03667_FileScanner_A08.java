import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03667_FileScanner_A08 {
    public static void main(String[] args) {
        String dirPath = "/path/to/your/directory"; // replace with your directory path
        File directory = new File(dirPath);

        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.canRead()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (!line.startsWith("//")) {
                                System.out.println(line);
                            }
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getPath());
                    }
                }
            }
        }
    }
}