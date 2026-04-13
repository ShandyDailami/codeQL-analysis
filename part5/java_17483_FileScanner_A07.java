import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17483_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File currentDir = new File(".");
        for (File file : currentDir.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                Scanner scanner = new Scanner(file);
                int lineCount = 0;
                while (scanner.hasNextLine()) {
                    scanner.nextLine();
                    lineCount++;
                }
                System.out.println("File: " + file.getName());
                System.out.println("Lines: " + lineCount);
            }
        }
    }
}