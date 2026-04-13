import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_13061_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File(".");

        File[] listOfFiles = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });

        if(listOfFiles != null) {
            for(File file1 : listOfFiles) {
                System.out.println(file1.getName());
            }
        }
    }
}