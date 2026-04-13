import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27984_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] list = directory.list();

        if (list != null) {
            for (String filename : list) {
                try {
                    Scanner scanner = new Scanner(new File(filename));

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