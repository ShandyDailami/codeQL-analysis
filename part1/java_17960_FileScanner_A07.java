import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_17960_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory"; // replace with your directory path
        String fileExtension = ".txt";

        File directory = new File(directoryPath);

        File[] txtFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(fileExtension);
            }
        });

        if (txtFiles != null) {
            Arrays.stream(txtFiles).forEach(file -> System.out.println(file.getPath()));
        } else {
            System.out.println("No .txt files found in the specified directory.");
        }
    }
}