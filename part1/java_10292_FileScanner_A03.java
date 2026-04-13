import java.io.File;
import java.util.ArrayList;

public class java_10292_FileScanner_A03 {
    public static void main(String[] args) {
        String rootDir = "C:\\path\\to\\your\\directory";
        ArrayList<String> dirs = new ArrayList<>();
        dirs.add(rootDir);

        while (!dirs.isEmpty()) {
            String dir = dirs.remove(0);
            File[] files = new File(dir).listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        dirs.add(file.getPath());
                    } else {
                        System.out.println(file.getPath());
                    }
                }
            }
        }
    }
}