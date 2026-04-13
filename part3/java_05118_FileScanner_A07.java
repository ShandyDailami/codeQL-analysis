import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05118_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");

        if (args.length == 1) {
            directory = new File(args[0]);
        }

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Input is not a directory!");
            return;
        }

        String[] list = directory.list();

        if (list == null) {
            System.out.println("No files in directory!");
            return;
        }

        for (String filename : list) {
            File file = new File(directory, filename);

            if (file.isFile() && file.canRead()) {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }

                scanner.close();
            }
        }
    }
}