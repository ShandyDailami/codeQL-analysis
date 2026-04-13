import java.io.File;
import java.io.FileFilter;

public class java_04760_FileScanner_A07 {

    public static void main(String[] args) {
        File currentDir = new File(".");
        findTextFiles(currentDir);
    }

    private static void findTextFiles(File dir) {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}