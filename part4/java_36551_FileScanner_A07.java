import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_36551_FileScanner_A07 {
    public static void main(String[] args) {
        File rootDir = new File(".");
        String[] files = rootDir.list(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        });
        if (files != null) {
            Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
            for (String file : files) {
                File sourceFile = new File(file);
                if (isAuthFailureClass(sourceFile)) {
                    System.out.println("AuthFailure in " + sourceFile.getAbsolutePath());
                }
            }
        }
    }

    private static boolean isAuthFailureClass(File sourceFile) {
        String fileContent = sourceFile.getName();
        return fileContent.contains("AuthFailure");
    }
}