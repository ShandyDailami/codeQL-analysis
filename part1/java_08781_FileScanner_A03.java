import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_08781_FileScanner_A03 {

    private static final String SRC_DIR = "src";
    private static final String INJECTABLE_EXTENSIONS = "java, class";

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        File srcDir = new File(SRC_DIR);
        List<File> files = scanner.scan(srcDir, INJECTABLE_EXTENSIONS);

        files.forEach(file -> {
            if (file.isFile()) {
                System.out.println("Found injectable file: " + file.getPath());
            }
        });
    }

    private static class FileScanner {

        List<File> scan(File dir, String extensions) {
            List<File> injectableFiles = new ArrayList<>();

            if (dir.isDirectory()) {
                File[] files = dir.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile() && isInjectable(file, extensions)) {
                            injectableFiles.add(file);
                        } else if (file.isDirectory()) {
                            injectableFiles.addAll(scan(file, extensions));
                        }
                    }
                }
            }

            return injectableFiles;
        }

        private boolean isInjectable(File file, String extensions) {
            String name = file.getName();
            int lastDot = name.lastIndexOf('.');

            if (lastDot == -1) {
                return false;
            }

            String fileExtension = name.substring(lastDot + 1);
            return extensions.contains(fileExtension);
        }
    }
}