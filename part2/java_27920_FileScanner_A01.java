import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_27920_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");

        try (Stream<Path> stream = Files.newDirectoryStream(path, "*.{txt,log}")) {
            List<Path> list = stream.collect(Collectors.toList());

            for (Path p : list) {
                File file = p.toFile();
                String name = file.getName();
                String extension = name.substring(name.lastIndexOf(".") + 1);

                if (extension.equals("txt") && file.canRead()) {
                    FileReader reader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(reader);

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println(line);
                    }

                    bufferedReader.close();
                }
            }
        }
    }
}