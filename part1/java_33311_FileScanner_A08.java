import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33311_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] list = directory.list();

        if (list != null) {
            for (String fileName : list) {
                File file = new File(fileName);

                if (file.isFile() && file.length() > 0) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}