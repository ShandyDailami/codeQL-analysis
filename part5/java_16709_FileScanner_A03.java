import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16709_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.canRead()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        System.out.println("Content of " + file.getName() + ":");
                        System.out.println(scanner.nextLine());
                    }
                    scanner.close();
                }
            }
        }
    }
}