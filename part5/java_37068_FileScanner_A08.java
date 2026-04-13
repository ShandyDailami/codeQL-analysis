import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37068_FileScanner_A08 {
    public static void main(String[] args) {
        File filesDir = new File(".");
        String[] fileList = filesDir.list();

        if (fileList != null) {
            for (String fileName : fileList) {
                if (fileName.endsWith(".txt")) {
                    try {
                        Scanner fileScanner = new Scanner(new File(fileName));
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            // TODO: Implement security measures related to A08_IntegrityFailure
                            // For example, you could perform a hash-check on the line, or a data type check
                        }
                        fileScanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + fileName);
                    }
                }
            }
        }
    }
}