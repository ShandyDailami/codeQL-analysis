import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class java_27332_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        };

        try (FileReader reader = new FileReader(dir)) {
            int c;
            while ((c = reader.read()) != -1) {
                if (c == '\n') {
                    System.out.println();
                } else {
                    System.out.print((char) c);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}