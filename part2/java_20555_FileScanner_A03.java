import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_20555_FileScanner_A03 {

    public static void main(String[] args) {

        String directoryPath = "C:\\test_directory"; // replace with your directory path
        String fileExtension = ".txt"; // replace with your file extension

        File directory = new File(directoryPath);

        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(fileExtension);
            }
        };

        File[] textFiles = directory.listFiles(fileFilter);

        if (textFiles == null) {
            System.out.println("No text files found in directory!");
            return;
        }

        System.out.println("Text files in directory: " + directory.getAbsolutePath());
        Arrays.stream(textFiles).forEach(file -> System.out.println(file.getName()));

    }

}