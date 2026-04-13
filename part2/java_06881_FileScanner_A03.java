import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06881_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the file: ");
        String path = scanner.nextLine();
        scanner.close();

        try {
            File file = new File(path);
            if (file.exists()) {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    // This is a security-sensitive operation related to injection attack
                    // The next line of the file is read and printed out, but also used as a part of a command string
                    // In reality, the injection attack can be used to execute arbitrary code
                    System.out.println(line);
                }
                fileScanner.close();
            } else {
                System.out.println("File not found!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}