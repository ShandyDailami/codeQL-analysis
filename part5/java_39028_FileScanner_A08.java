import java.io.File;
import java.util.Scanner;

public class java_39028_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");

        if (args.length == 0) {
            file = file.getAbsoluteFile();
        } else {
            file = new File(args[0]);
        }

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("security")) {
                System.out.println(line);
            }
        }

        scanner.close();
    }
}