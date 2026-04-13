import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18911_FileScanner_A07 {
    public static void main(String[] args) {
        // create the directory
        File dir = new File(".");

        // create the directory iterator
        File[] list = dir.listFiles();

        if (list != null) {
            for (File file : list) {
                if (file.isFile()) {
                    try {
                        // create a new scanner for the file
                        Scanner scanner = new Scanner(file);

                        // read and print the file content
                        while (scanner.hasNext()) {
                            System.out.println(scanner.nextLine());
                        }

                        // close the scanner
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}