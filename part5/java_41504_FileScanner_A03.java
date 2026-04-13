import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41504_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the file path:");
        String filePath = input.nextLine();

        try {
            File file = new File(filePath);

            if (file.exists()) {
                Scanner fileScanner = new Scanner(file);

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }

                fileScanner.close();
            } else {
                System.out.println("File does not exist!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}