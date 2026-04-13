import java.io.File;
import java.util.Scanner;

public class java_37270_FileScanner_A08 {
    public static void main(String[] args) {
        File currentDir = new File(".");
        String[] list = currentDir.list();

        if (list != null) {
            for (String filename : list) {
                File file = new File(filename);

                // Ignore files in parent directory
                if (file.isDirectory() && !file.getName().equals("..") && !file.getName().equals(".")) {
                    continue;
                }

                // Read file
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                } catch (Exception e) {
                    // Handle exception
                    System.out.println("Error reading file: " + filename);
                }
            }
        }
    }
}