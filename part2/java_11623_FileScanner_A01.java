import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11623_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("."); // current directory
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) { // Only txt files
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line); // Prints the content of the file
                    }
                    scanner.close();
                }
            }
        }
    }
}