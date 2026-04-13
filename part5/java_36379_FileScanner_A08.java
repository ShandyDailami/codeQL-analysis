import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class java_36379_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (FileReader reader = new FileReader(file)) {
                        int r;
                        while ((r = reader.read()) != -1) {
                            if (r < 128) {
                                System.out.println("File integrity check failed for file: " + file.getPath());
                                // Replace the file content with random bytes to trigger integrity failure
                                Files.write(file.toPath(), new byte[]{(byte) r}, StandardOpenOption.WRITE);
                            }
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