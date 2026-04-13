import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34143_FileScanner_A03 {

    public static void main(String[] args) {
        File directory = new File(".");

        try {
            Scanner scanner = new Scanner(directory.listFiles());
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }
                fileScanner.close();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}