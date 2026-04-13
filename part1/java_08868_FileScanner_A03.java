import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08868_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] allFiles = dir.listFiles();
            for (File file : allFiles) {
                if (file.isFile() && file.canRead()) {
                    readFile(file);
                }
            }
        } else {
            System.out.println("Invalid directory path!");
        }

        scanner.close();
    }

    private static void readFile(File file) {
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // Here we are not doing any security sensitive operation, just reading the file.
                System.out.println(line);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getName());
        }
    }
}