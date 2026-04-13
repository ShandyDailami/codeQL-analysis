import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02745_FileScanner_A01 {
    public static void main(String[] args) {
        File currentDir = new File(".");
        try (Scanner scanner = new Scanner(currentDir)) {
            while (scanner.hasNext()) {
                String fileName = scanner.next();
                File file = new File(fileName);
                if (file.exists() && file.canRead()) {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        // Do something with the line, e.g., print it
                        System.out.println(line);
                    }
                    fileScanner.close();
                } else {
                    System.out.println("File " + fileName + " does not exist or is not readable.");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}