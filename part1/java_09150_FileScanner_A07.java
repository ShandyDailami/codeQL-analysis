import java.io.*;
import java.util.Scanner;

public class java_09150_FileScanner_A07 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.start();
    }

    static class FileScanner {
        private static final String DIR_PATH = "src/main/java/A07_AuthFailure";

        public void start() {
            File dir = new File(DIR_PATH);
            File[] files = dir.listFiles((d, name) -> name.endsWith(".txt"));

            if (files == null) {
                System.out.println("No txt files found in " + DIR_PATH);
                return;
            }

            for (File file : files) {
                printFileContent(file);
            }
        }

        private void printFileContent(File file) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + file.getName());
            }
        }
    }
}