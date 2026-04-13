import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14920_FileScanner_A01 {

    public static void main(String[] args) {
        File directory = new File(".");
        String[] list = directory.list();

        if (list == null) {
            System.out.println("No files or directories found!");
            return;
        }

        for (String fileName : list) {
            File file = new File(fileName);

            if (file.isFile() && !file.getName().endsWith(".bak")) {
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