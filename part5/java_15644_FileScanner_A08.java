import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15644_FileScanner_A08 {
    private static final String DIR = "C:\\path\\to\\directory";
    private static final String FILE = "C:\\path\\to\\file";

    public static void main(String[] args) {
        File dir = new File(DIR);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Process the line here, for example, by checking the length or content
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getName());
                    }
                }
            }
        }
    }
}