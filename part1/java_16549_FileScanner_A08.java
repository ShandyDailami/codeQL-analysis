import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16549_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String dir = "/path/to/directory"; // replace with your directory path
        File directory = new File(dir);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                        scanner.close();
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or it is not a directory.");
        }
    }
}