import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16637_FileScanner_A08 {
    public static void main(String[] args) {
        File currentDir = new File(".");
        try {
            Scanner scanner = new Scanner(currentDir);
            while(scanner.hasNextLine()) {
                String fileName = scanner.nextLine();
                File file = new File(fileName);
                if (file.exists() && !file.isDirectory()) {
                    System.out.println("Reading file: " + fileName);
                    Scanner fileScanner = new Scanner(file);
                    while(fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                   
                    }
                    fileScanner.close();
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}