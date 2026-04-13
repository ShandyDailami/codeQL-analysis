import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class java_29549_FileScanner_A07 {
    private static final String START_WITH = "A";
    private static final String END_WITH = ".txt";

    public static void main(String[] args) {
        String directoryPath = "path_to_your_directory";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                List<File> txtFiles = Arrays.stream(files)
                        .filter(file -> file.isFile() && file.getName().startsWith(START_WITH) && file.getName().endsWith(END_WITH))
                        .collect(Collectors.toList());

                txtFiles.forEach(file -> System.out.println(file.getName()));
            } else {
                System.out.println("No files found in the specified directory.");
            }
        } else {
            System.out.println("The specified directory does not exist or is not a directory.");
        }
    }
}