import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33219_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] list = directory.list();
        if (list != null) {
            for (String fileName : list) {
                File file = new File(fileName);
                if (file.isFile()) {
                    if (fileName.endsWith(".java")) {
                        try {
                            Scanner scanner = new Scanner(file);
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                if (line.contains("A08_IntegrityFailure")) {
                                    System.out.println("IntegrityFailure: " + fileName);
                                }
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
}