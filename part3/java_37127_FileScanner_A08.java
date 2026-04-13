import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37127_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        String[] list = directory.list();

        if (list == null) {
            System.out.println("No text files in current directory!");
            return;
        }

        for (String fileName : list) {
            if (fileName.endsWith(".txt")) {
                Scanner scanner = new Scanner(new File(fileName));
                while (scanner.hasNextLine()) {
                    System.out.println("Content of " + fileName + ":");
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            }
        }
    }
}