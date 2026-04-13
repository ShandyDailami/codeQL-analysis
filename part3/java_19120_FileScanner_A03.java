import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19120_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "path/to/directory";
        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            System.out.println("Searching for files in: " + directoryPath);

            String[] files = directory.list();

            for (String file : files) {
                File fileToRead = new File(directoryPath + "/" + file);
                Scanner fileScanner = new Scanner(fileToRead);

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }

                fileScanner.close();
            }
        } else {
            System.out.println(directoryPath + " is not a directory");
        }
    }
}