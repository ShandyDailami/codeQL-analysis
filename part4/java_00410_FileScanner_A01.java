import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00410_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("brokenAccessControlFile.txt"));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file 'brokenAccessControlFile.txt' was not found. Please ensure the file is in the same directory as your program and that it has the required permissions.");
        }
    }
}