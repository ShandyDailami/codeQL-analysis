import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03650_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File("./src"); // replace with your directory
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.canRead()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}