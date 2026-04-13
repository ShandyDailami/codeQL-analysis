import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_02678_FileScanner_A01 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory
        String extension = ".txt"; // replace with your file extension

        File dir = new File(directory);
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        if (files != null) {
            Arrays.sort(files, (o1, o2) -> {
                if (o1.isDirectory() && o2.isFile()) return -1;
                if (o2.isDirectory() && o1.isFile()) return 1;
                return o1.compareTo(o2);
            });

            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("Directory is empty!");
        }
    }
}