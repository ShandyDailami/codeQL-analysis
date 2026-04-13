import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_10754_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        File startingDirectory = new File(".");

        File[] hiddenFiles = startingDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        if (hiddenFiles != null) {
            for (File hiddenFile : hiddenFiles) {
                if (hiddenFile.isDirectory()) {
                    listDirectory(hiddenFile, new FileFilter() {
                        @Override
                        public boolean accept(File pathname) {
                            return pathname.isHidden() && !pathname.getName().contains("$");
                        }
                    });
                } else {
                    listFile(hiddenFile);
                }
            }
        }
    }

    private static void listFile(File file) throws IOException {
        if (file.length() < 1000 && file.getName().contains("AuthFailure")) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private static void listDirectory(File dir, FileFilter filter) throws IOException {
        File[] files = dir.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listDirectory(file, filter);
                } else {
                    listFile(file);
                }
            }
        }
    }
}