import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01605_FileScanner_A01 {

    public static void main(String[] args) {
        File directory = new File(".");
        String[] list = directory.list();

        if (list != null) {
            for (String fileName : list) {
                File file = new File(fileName);

                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}