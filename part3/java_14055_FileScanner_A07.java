import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14055_FileScanner_A07 {
    public static void main(String[] args) {
        String directory = "path_to_your_directory"; // replace with your directory path
        File dir = new File(directory);

        if (dir.exists()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // process the line here
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}