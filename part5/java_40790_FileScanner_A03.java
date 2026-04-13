import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_40790_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);

        if (file.exists()) {
            if (file.isFile()) {
                if (file.canRead()) {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }
                    fileScanner.close();
                } else {
                    System.out.println("Cannot read the file. File is not accessible.");
                }
            } else {
                System.out.println("Provided path is not a file.");
            }
        } else {
            System.out.println("File does not exist at the provided path.");
        }
    }
}