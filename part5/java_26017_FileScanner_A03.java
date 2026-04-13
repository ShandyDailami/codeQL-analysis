import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class java_26017_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            List<File> files = Arrays.stream(directory.listFiles())
                    .filter(file -> file.isFile() && !file.getName().contains(".."))
                    .collect(Collectors.toList());

            for (File file : files) {
                System.out.println("File: " + file.getName());
            }
        } else {
            System.out.println("Directory does not exist!");
        }
    }
}