import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05363_FileScanner_A08 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try {
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                System.out.println(line);
                            }
                            fileScanner.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getPath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + dirPath);
        }

        scanner.close();
    }
}