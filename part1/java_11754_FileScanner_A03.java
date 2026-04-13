import java.io.File;
import java.util.Scanner;

public class java_11754_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file extension you want to scan: ");
        String extension = scanner.next();
        String directory = System.getProperty("user.dir") + "/src";

        File file = new File(directory);

        File[] listOfFiles = file.listFiles((dir, name) -> name.endsWith(extension));

        if (listOfFiles != null) {
            for (File inputFile : listOfFiles) {
                Scanner fileScanner = new Scanner(inputFile);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
                fileScanner.close();
            }
        }
        scanner.close();
    }
}