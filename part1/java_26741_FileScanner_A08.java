import java.io.File;
import java.util.Arrays;
import java.util.List;

public class java_26741_FileScanner_A08 {
    private static final List<String> EXTENSIONS = Arrays.asList("txt", "java");

    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory

        File dir = new File(directory);

        File[] listOfFiles = dir.listFiles((dir2, name) -> {
            String nameLowerCase = name.toLowerCase();
            return EXTENSIONS.stream().anyMatch(extension -> nameLowerCase.endsWith(extension));
        });

        if (listOfFiles != null) {
            Arrays.stream(listOfFiles).forEach(file -> {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                }
            });
        }
    }
}