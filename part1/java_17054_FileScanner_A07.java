import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_17054_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.next();

        File dir = new File(dirPath);

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();

            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    try {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println(line);
                        }
                        fileScanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("Path is not a directory: " + dirPath);
        }

        scanner.close();
    }
}