import java.io.File;
import java.util.Scanner;

public class java_08515_FileScanner_A01 {
    public static void main(String[] args) {
        // create a FileScanner object to read the file
        FileScanner fileScanner = new FileScanner();

        // get the file path from the user
        System.out.println("Enter the file path:");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();

        // read the file
        File file = new File(filePath);
        if (file.exists()) {
            Scanner scannerFile = new Scanner(file);

            // print the content of the file
            while (scannerFile.hasNextLine()) {
                String line = scannerFile.nextLine();
                System.out.println(line);
            }
            scannerFile.close();
        } else {
            System.out.println("File not found!");
        }
    }
}