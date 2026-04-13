import java.io.*;
import java.util.*;

public class java_28848_FileScanner_A08 {

    public static void main(String[] args) {
        File file = new File("target");
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isFile()) {
                        try (FileReader reader = new FileReader(f)) {
                            Scanner scanner = new Scanner(reader);
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println(line);
                            }
                            scanner.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + f.getPath());
                        }
                    }
                }
            }
        }
    }
}