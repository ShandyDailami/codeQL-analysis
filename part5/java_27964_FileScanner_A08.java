import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class java_27964_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        File rootDirectory = new File(".");
        String[] extensions = {"txt", "doc", "docx", "pdf", "png", "jpg", "jpeg"};
        File[] files = rootDirectory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return Arrays.asList(extensions).contains(name.substring(name.lastIndexOf(".") + 1));
            }
        });
        if (files != null) {
            for (File file : files) {
                Path path = Paths.get(file.getAbsolutePath());
                if (Files.isReadable(path)) {
                    System.out.println("File: " + file.getName() + " - " + "Path: " + file.getAbsolutePath());
                } else {
                    System.out.println("Security violation: " + file.getName() + " is not readable");
                }
            }
        } else {
            System.out.println("Directory does not exist or does not have read access");
        }
    }
}