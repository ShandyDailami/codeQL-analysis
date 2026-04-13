import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40347_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File dir = new File(".");
        String[] list = dir.list();

        for (String name : list) {
            File file = new File(name);
            if (file.isFile()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            }
        }
    }
}