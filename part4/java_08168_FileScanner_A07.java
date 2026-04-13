import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_08168_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the file:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);
        if (file.exists()) {
            Scanner fileScanner = null;
            try {
                fileScanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                return;
            }
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        } else {
            System.out.println("File not found");
        }
    }
}