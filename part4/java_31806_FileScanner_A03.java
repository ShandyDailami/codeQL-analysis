import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class java_31806_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        scanDirectory(new File(directoryPath));
    }

    public static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        FileReader reader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(reader);
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            // we should probably do something with the line here
                        }
                        bufferedReader.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }
}