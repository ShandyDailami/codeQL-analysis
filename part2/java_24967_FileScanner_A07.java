import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24967_FileScanner_A07 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with your directory path
        scanDirectory(new File(dirPath));
    }

    private static void scanDirectory(File dir) {
        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println(line); // replace with your security-sensitive operation
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else if (file.isDirectory()) {
                        scanDirectory(file);
                    }
                }
            }
        }
    }
}