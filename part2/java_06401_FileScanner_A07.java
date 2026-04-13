import java.io.File;
import java.util.Scanner;

public class java_06401_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("your_file_path");
        Scanner scanner = new Scanner(file);

        System.out.println("Enter keyword to search: ");
        String keyword = scanner.next();

        int count = 0;
        while (scanner.hasNext()) {
            if (scanner.next().contains(keyword)) {
                count++;
            }
        }

        System.out.println("Keyword found " + count + " times.");
        scanner.close();
    }
}