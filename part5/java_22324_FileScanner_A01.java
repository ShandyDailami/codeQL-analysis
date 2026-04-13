import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_22324_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("C:/Users/Public/Documents");
        printFilesWithCorrectName(file);
    }

    private static void printFilesWithCorrectName(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    printFilesWithCorrectName(f);
                }
            }
        } else {
            if (file.getName().startsWith("a") && file.getName().endsWith("1.txt")) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}