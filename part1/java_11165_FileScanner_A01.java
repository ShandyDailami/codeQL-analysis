import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11165_FileScanner_A01 {
    public static void main(String[] args) {
        // create a file scanner to read the file
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        // create a file object to handle the file
        File file = new File(filePath);

        // check if the file exists
        if (file.exists()) {
            // create a file scanner to read the file
            Scanner fileScanner = null;
            try {
                fileScanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            // read the file and print out each line
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            // close the file scanner
            fileScanner.close();
        } else {
            System.out.println("File not found!");
        }
    }
}