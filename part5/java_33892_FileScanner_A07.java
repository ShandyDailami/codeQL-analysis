import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33892_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        String dirPath = "/path/to/directory"; // Replace with your directory path
        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                        scanner.close();
                    }
                }
            } else {
                System.out.println("No files in the directory!");
            }
        } else {
            System.out.println("Directory does not exist!");
        }
    }
}