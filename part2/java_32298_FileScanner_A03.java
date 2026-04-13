import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_32298_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String prefix = "prefix_";
        String suffix = "_suffix";

        File directory = new File(directoryPath);
        Pattern pattern = Pattern.compile(prefix + ".*" + suffix);

        File[] files = directory.listFiles((dir, name) -> pattern.matcher(name).matches());

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (FileReader reader = new FileReader(file)) {
                        int character;
                        while ((character = reader.read()) != -1) {
                            System.out.print((char) character);
                        }
                        System.out.println();
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