import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class java_11810_FileScanner_A07 {
    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList("txt", "jpg", "jpeg", "png", "gif", "pdf", "zip");

    public static void main(String[] args) {
        File folder = new File("C:\\FolderPath");
        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile() && isAllowedExtension(file.getAbsolutePath())) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    private static boolean isAllowedExtension(String filePath) {
        String fileName = new File(filePath).getName();
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return false;
        }
        String extension = fileName.substring(lastDotIndex + 1);
        return ALLOWED_EXTENSIONS.contains(extension);
    }
}