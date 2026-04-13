import java.io.File;
import java.util.Scanner;

public class java_10422_FileScanner_A08 {
    public static void main(String[] args) {
        File dir = new File(".");
        String[] list = dir.list();

        if (list != null) {
            for (String fileName : list) {
                if (fileName.endsWith(".txt")) {
                    File file = new File(fileName);
                    Scanner scanner = null;

                    try {
                        scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                        scanner.close();
                    } catch (Exception e) {
                        System.out.println("Error reading file: " + fileName);
                    }
                }
            }
        }
    }
}