import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_35052_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = sc.nextLine();

        File file = new File(filePath);

        if (file.exists()) {
            Scanner fileScanner = new Scanner(file);
            System.out.println("Enter the string to scan: ");
            String searchString = sc.nextLine();

            int lineNumber = 0;
            while (fileScanner.hasNextLine()) {
                lineNumber++;
                String line = fileScanner.nextLine();
                if (line.contains(searchString)) {
                    System.out.println("Found in line " + lineNumber + ": " + line);
                }
            }
            fileScanner.close();
        } else {
            System.out.println("File does not exist");
        }
    }
}