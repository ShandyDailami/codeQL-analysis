import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class java_40034_FileScanner_A03 {

    public static void main(String[] args) {
        scanDirectory("C:\\Windows\\System32", ".*\\.dll");
    }

    public static void scanDirectory(String directoryPath, String fileExtension) {
        File directory = new File(directoryPath);

        File[] matchingFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && Pattern.matches(fileExtension, pathname.getName());
            }
        });

        for (File file : matchingFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }

}