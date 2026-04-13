import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08993_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "path/to/directory";
        String searchFile = "A07_AuthFailure.txt";

        File directory = new File(directoryPath);
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.getName().equals(searchFile)) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getPath());
                    }
                }
            }
        }
    }
}