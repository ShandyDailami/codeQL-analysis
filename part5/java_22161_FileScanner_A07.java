import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class java_22161_FileScanner_A07 {

    public static List<File> scanDirectory(String directoryPath, final String extension) {
        List<File> files = new ArrayList<>();

        File dir = new File(directoryPath);

        File[] listOfFiles = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(extension);
            }
        });

        for (File file : listOfFiles) {
            files.add(file);
        }

        return files;
    }

    public static void main(String[] args) {
        List<File> txtFiles = scanDirectory(".", ".txt");

        for (File file : txtFiles) {
            System.out.println("File found: " + file.getAbsolutePath());
        }
    }
}