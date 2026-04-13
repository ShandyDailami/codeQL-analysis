import java.io.File;
import java.util.Scanner;

public class java_02721_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("myfile.txt");
        if (file.exists()) {
            System.out.println("File exists!");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } else {
            System.out.println("File does not exist!");
        }
    }
}