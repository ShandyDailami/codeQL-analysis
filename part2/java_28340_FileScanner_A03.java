import java.io.File;
import java.util.Scanner;

public class java_28340_FileScanner_A03 {
    public static void main(String[] args) {
        String searchString = "sensitive";
        String filePath = "/path/to/your/file.txt"; // Replace with your file path

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(searchString)) {
                    System.out.println("The file contains the string: " + searchString);
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}