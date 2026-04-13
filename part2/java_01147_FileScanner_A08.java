import java.io.File;
import java.util.Scanner;

public class java_01147_FileScanner_A08 {
    private static final String PATH = "src/main/resources/";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the file name:");
        String fileName = input.next();

        try {
            File file = new File(PATH + fileName);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            fileScanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred while trying to read the file.");
        }
    }
}