import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35819_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the path to the file you want to scan:");
        String path = scanner.nextLine();

        try {
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
                        System.out.println("The file is not readable!");
                    }
                } else {
                    System.out.println("The provided path is not a file!");
                }
            } else {
                System.out.println("The file does not exist!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}