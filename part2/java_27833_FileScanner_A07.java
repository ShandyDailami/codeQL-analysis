import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27833_FileScanner_A07 {

    private static final String DIRECTORY = "path/to/directory"; // Replace with your directory

    public static void main(String[] args) throws FileNotFoundException {
        File dir = new File(DIRECTORY);

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead() && !file.getName().endsWith(".log")) {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains("FAILURE")) {
                                System.out.println("Auth failure detected in: " + file.getAbsolutePath());
                            }
                        }
                        scanner.close();
                    }
                }
            }
        } else {
            System.out.println("Invalid directory");
        }
    }
}