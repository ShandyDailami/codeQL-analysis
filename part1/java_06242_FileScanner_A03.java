import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06242_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();
        File file = new File(path);

        try {
            fileScanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void fileScanner(File file) throws FileNotFoundException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    fileScanner(f);
                }
            }
        } else {
            if (file.getName().endsWith(".txt")) {
                System.out.println("File: " + file.getAbsolutePath());
            }
        }
    }
}