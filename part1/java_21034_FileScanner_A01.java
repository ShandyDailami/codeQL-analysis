import java.io.File;
import java.util.Scanner;

public class java_21034_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("yourfile.txt"); // replace with your file path
        Scanner scanner = new Scanner(file);

        String keyword = "your keyword here"; // replace with your keyword
        System.out.println("Scanning for keyword: " + keyword);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(keyword)) {
                System.out.println("Keyword found in line: " + line);
            }
        }

        scanner.close();
    }
}