import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

public class java_30411_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        List<String> fileExtensions = Arrays.asList("jpg", "png", "jpeg");

        File directory = new File(directoryPath);

        File[] files = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                String name = pathname.getName();
                int lastDotIndex = name.lastIndexOf(".");
                String extension = lastDotIndex != -1 ? name.substring(lastDotIndex + 1) : null;
                return fileExtensions.contains(extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.canRead()) {
                    System.out.println("File '" + file.getPath() + "' is readable.");
                } else {
                    System.out.println("File '" + file.getPath() + "' is not readable.");
                }
            }
        } else {
            System.out.println("Directory is empty.");
        }
    }
}