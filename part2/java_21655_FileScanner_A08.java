import java.io.*;
import java.nio.file.*;

public class java_21655_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "path_to_your_directory";
        try {
            Files.walk(Paths.get(directoryPath))
                .filter(Files::isRegularFile)
                .forEach(filePath -> {
                    try {
                        File file = filePath.toFile();
                        if (file.getName().endsWith(".txt")) {
                            FileReader reader = new FileReader(file);
                            BufferedReader bufferedReader = new BufferedReader(reader);
                            String line;
                            while ((line = bufferedReader.readLine()) != null) {
                                System.out.println(line);
                            }
                            bufferedReader.close();
                            reader.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}