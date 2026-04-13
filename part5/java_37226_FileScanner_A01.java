import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37226_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        String[] list = directory.list();

        if (list == null) {
            System.out.println("No files or directories found.");
            return;
        }

        for (String str : list) {
            File file = new File(str);

            if (file.isFile() && !file.getName().endsWith(".java")) {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }

                scanner.close();
            } else if (file.isDirectory() && file.getName().equals("target")) {
                System.out.println("Skipping directory: " + file.getName());
            }
        }
    }
}