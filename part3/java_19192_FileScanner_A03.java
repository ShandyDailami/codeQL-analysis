import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_19192_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        File[] javaFiles = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });

        for (File file : javaFiles) {
            System.out.println(file.getPath());
        }
    }
}