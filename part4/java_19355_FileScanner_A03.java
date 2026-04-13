import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class java_19355_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "path_to_directory";
        File dir = new File(directoryPath);

        File[] hiddenFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No hidden files found in " + dir);
        }
    }
}