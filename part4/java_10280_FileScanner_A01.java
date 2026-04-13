import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_10280_FileScanner_A01 {

    public static void main(String[] args) {
        File rootDir = new File(".");
        String[] directories = rootDir.list(new DirFilter());
        Arrays.sort(directories);
        for (String dir : directories) {
            File dirFile = new File(dir);
            if (dirFile.isDirectory()) {
                String[] dirs = dirFile.list(new DirFilter());
                Arrays.sort(dirs);
                for (String file : dirs) {
                    File fileObj = new File(dirFile, file);
                    if (fileObj.isFile()) {
                        System.out.println(fileObj.getPath());
                    }
                }
            }
        }
    }

    private static class DirFilter implements FileFilter {
        public boolean accept(File pathname) {
            // Filter for directories and files that start with a number.
            return !pathname.getName().isEmpty() && (
                    pathname.isDirectory() ||
                            (pathname.getName().charAt(0) >= '0' && pathname.getName().charAt(0) <= '9'));
        }
    }
}