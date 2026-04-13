import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36515_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        String dirPath = "./src/main/resources/"; // replace with your directory path
        File directory = new File(dirPath);
        File[] listOfFiles = directory.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            }
        }
    }
}