import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29276_FileScanner_A07 {

    public static void main(String[] args) {
        String directory = "/path/to/your/directory"; // replace with your directory
        String type = ".txt"; // replace with your file type
        scanFiles(directory, type);
    }

    public static void scanFiles(String directory, String type) {
        File file = new File(directory);
        File[] listOfFiles = file.listFiles();

        if (listOfFiles != null) {
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile() && listOfFile.getName().endsWith(type)) {
                    try {
                        Scanner scanner = new Scanner(listOfFile);
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
}