import java.io.File;
import java.io.FileFilter;

public class java_27504_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        findJavaFiles(directoryPath);
    }

    private static void findJavaFiles(String directoryPath) {
        File directory = new File(directoryPath);
        FileFilter javaFileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

        File[] javaFiles = directory.listFiles(javaFileFilter);

        if (javaFiles != null) {
            for (File javaFile : javaFiles) {
                System.out.println(javaFile.getAbsolutePath());
            }
        }
    }
}