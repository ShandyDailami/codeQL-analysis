import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class java_16352_FileScanner_A07 {
    public static void main(String[] args) {
        File root = new File(".");

        List<File> files = new ArrayList<>();
        listFiles(root, new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir, name);
                if (file.isFile() && file.getName().endsWith(".java")) {
                    files.add(file);
                }
                return true;
            }
        });

        for (File file : files) {
            System.out.println(file.getPath());
        }
    }

    private static void listFiles(File dir, FilenameFilter filter) {
        File[] list = dir.listFiles(filter);
        if (list == null) {
            return;
        }
        for (File file : list) {
            if (file.isDirectory()) {
                listFiles(file, filter);
            } else {
                filter.accept(file.getParentFile(), file.getName());
            }
        }
    }
}