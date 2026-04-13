import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_25325_FileScanner_A01 {

    private static final String DIRECTORY_TO_SCAN = "C:/your/directory/path"; // replace with your directory

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name: ");
        String fileName = scanner.next();

        File file = new File(DIRECTORY_TO_SCAN, fileName);

        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}