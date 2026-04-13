import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_18660_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            File myFile = new File("./myfile.txt");
            if (myFile.canRead()) {
                Scanner scanner = new Scanner(myFile);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
                scanner.close();
            } else {
                System.out.println("Cannot read file. Check the file permissions.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}