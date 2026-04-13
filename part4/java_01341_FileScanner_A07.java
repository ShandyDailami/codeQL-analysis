import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01341_FileScanner_A07 {

    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // specify your directory path here
        File directory = new File(dirPath);

        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                Scanner scanner = null;
                try {
                    scanner = new Scanner(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains("AuthFailure")) {
                        System.out.println("File: " + file.getName() + " contains 'AuthFailure'");
                    }
                }
                scanner.close();
            }
        }
    }
}