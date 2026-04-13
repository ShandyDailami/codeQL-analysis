import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class java_28945_FileScanner_A08 {
    public static void main(String[] args) {
        String dirPath = "/path/to/your/directory";  // Adjust this
        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        try (FileReader reader = new FileReader(file)) {
                            int r;
                            while ((r = reader.read()) != -1) {
                                // You could add your security-sensitive operations here, for example, checking file's integrity
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}