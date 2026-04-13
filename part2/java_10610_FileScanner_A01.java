import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10610_FileScanner_A01 {
    private static final String DIRECTORY = "./src/main/resources";

    public static void main(String[] args) throws FileNotFoundException {
        File dir = new File(DIRECTORY);
        if (dir.exists()) {
            File[] listOfFiles = dir.listFiles();
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                }
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }
    }
}