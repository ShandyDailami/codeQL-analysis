import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16584_FileScanner_A08 {

    public static void main(String[] args) {
        String directory = "/path/to/directory";
        File dir = new File(directory);

        if (dir.exists()) {
            File[] listOfFiles = dir.listFiles();
            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // Perform some security-sensitive operation here
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + directory);
        }
    }
}