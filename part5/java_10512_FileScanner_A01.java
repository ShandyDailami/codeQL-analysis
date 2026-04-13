import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10512_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File(".");
        String pattern = "*.java";
        fileScan(directory, pattern);
    }

    public static void fileScan(File directory, String pattern) {
        File[] foundFiles = directory.listFiles((dir, name) -> name.matches(pattern));

        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (file.isDirectory()) {
                    fileScan(file, pattern);
                }
            }
        }
    }
}