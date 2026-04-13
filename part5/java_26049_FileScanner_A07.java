import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26049_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String directory = "/path/to/directory"; // replace with your directory path
        File dir = new File(directory);

        if (dir.exists()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("Reading file: " + file.getName());
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                    scanner.close();
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }
    }
}