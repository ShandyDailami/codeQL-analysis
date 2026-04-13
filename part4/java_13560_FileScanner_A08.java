import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13560_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");

        if (directory.isDirectory()) {
            String[] files = directory.list();

            for (String file : files) {
                File fileEntry = new File(file);

                if (fileEntry.isFile()) {
                    Scanner scanner = new Scanner(fileEntry);

                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }

                    scanner.close();
                }
            }
        }
    }
}