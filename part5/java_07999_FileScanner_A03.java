import java.io.File;
import java.io.FileFilter;

public class java_07999_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File dir = new File(directoryPath);

        File[] hiddenFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.isHidden();
            }
        });

        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.printf("Directory: %s%n", file.getAbsolutePath());
                }
            }
        }
    }
}