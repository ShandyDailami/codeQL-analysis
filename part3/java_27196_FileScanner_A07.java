import java.io.File;
import java.util.Scanner;

public class java_27196_FileScanner_A07 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (file.exists()) {
            scanner = new Scanner(file);
            System.out.print("Enter the search string: ");
            String searchString = scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(searchString)) {
                    System.out.println("File contains the string: " + searchString);
                    break;
                }
            }
            scanner.close();

        } else {
            System.out.println("File does not exist.");
        }
    }
}