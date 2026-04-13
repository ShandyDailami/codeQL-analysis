import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12102_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(".");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String fileName = scanner.nextLine();
            Scanner fileScanner = new Scanner(new File(fileName));

            while (fileScanner.hasNext()) {
                System.out.println(fileScanner.nextLine());
            }

            fileScanner.close();
        }

        scanner.close();
    }
}