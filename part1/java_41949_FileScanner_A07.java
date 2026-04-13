import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_41949_FileScanner_A07 {

    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory

        File fileDir = new File(directory);

        if (fileDir.isDirectory()) {
            File[] listOfFiles = fileDir.listFiles();

            for (File file : listOfFiles) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}