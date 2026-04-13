import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_16306_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File(".");
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };
        File[] textFiles = directory.listFiles(fileFilter);
        if(textFiles != null) {
            for(File textFile : textFiles) {
                Scanner scanner = new Scanner(textFile);
                while(scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println("Read line: " + line);
                }
                scanner.close();
            }
        }
    }
}