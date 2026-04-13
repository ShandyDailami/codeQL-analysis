import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13303_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {

        File directory = new File(".");

        String[] list = directory.list();

        if (list != null) {
            for (String fileName : list) {
                File file = new File(fileName);
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
                scanner.close();
            }
        }

        // Show the injection vulnerability
        try {
            String input = "cat /etc/passwd";
            Runtime.getRuntime().exec(input);
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

    }

}