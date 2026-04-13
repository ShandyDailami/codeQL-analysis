import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_19552_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File(".");
        String searchFile = "A03_Injection.java";
        findFile(directory, searchFile);
    }

    public static void findFile(File directory, String searchFile) {
        File[] list = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().equals(searchFile);
            }
        });

        if (list != null) {
            for (File file : list) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("File not found in " + directory.getPath());
        }
    }
}