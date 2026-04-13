import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_26471_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File(".");

        String[] extensions = new String[]{"txt", "jpg", "png", "gif"};

        File[] listOfFiles = directory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                for (String extension : extensions) {
                    if (name.endsWith(extension)) {
                        return true;
                    }
                }
                return false;
            }
        });

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files with these extensions found!");
        }
    }
}