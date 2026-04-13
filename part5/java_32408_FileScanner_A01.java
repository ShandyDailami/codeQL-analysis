import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32408_FileScanner_A01 {
    private static final String DIR_PATH = "./src/main/resources/";

    public static void main(String[] args) {
        File dir = new File(DIR_PATH);
        File[] dirContents = dir.listFiles();
        if (dirContents != null) {
            for (File file : dirContents) {
                if (file.isFile()) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains("password") || line.contains("username")) {
                                System.out.println("Security Violation found in: " + file.getPath());
                            }
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getPath());
                    }
                }
            }
        }
    }
}