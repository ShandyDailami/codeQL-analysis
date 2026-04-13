import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_27434_FileScanner_A08 {
    public static void main(String[] args) {
        File currentDir = new File(".");
        String[] fileList;

        fileList = currentDir.list(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".java");
            }
        });

        Arrays.sort(fileList);

        System.out.println("File names ending with .java: ");

        for (String fileName : fileList) {
            System.out.println(fileName);
        }
    }
}