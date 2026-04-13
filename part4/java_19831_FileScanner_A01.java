import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19831_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "path_to_directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        File[] hiddenFiles = directory.listFiles(new FileFilter() {
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
            System.out.println("No hidden files in directory.");
        }
    }

}