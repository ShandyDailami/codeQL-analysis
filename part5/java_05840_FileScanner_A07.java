import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class java_05840_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File("."); // use current directory
        String rootPath = directory.getAbsolutePath();

        try (Scanner scanner = new Scanner(Paths.get(rootPath + "/file_list.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                File file = new File(line);

                // check if file is accessible
                if (file.canRead()) {
                    // check if file is a regular file
                    if (file.isFile()) {
                        // check if file is a text file and has 1000 characters or more
                        if (file.isFile() && file.length() >= 1000) {
                            System.out.println(file.getPath());
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}