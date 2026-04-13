import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_09040_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the path to the file: ");
        String filePath = input.nextLine();

        try {
            File myFile = new File(filePath);
            if (myFile.exists()) {
                Scanner fileScanner = new Scanner(myFile);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
                fileScanner.close();
            } else {
                System.out.println("The file " + filePath + " does not exist.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        input.close();
    }
}