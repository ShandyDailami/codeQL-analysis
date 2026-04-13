import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_37258_FileScanner_A07 {
    private static final String SENSITIVE_EXTENSIONS = "exe, dll, doc, txt, bin, xml, ppt, pptx, pdf, jpeg, jpg, gif, csv";
    private static final String SENSITIVE_MIMETYPES = "application/octet-stream, application/msword, text/plain, application/vnd.ms-excel, image/jpeg, image/jpg, image/gif, text/csv";

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*" + SensitiveFileScanner.SENSITIVE_EXTENSIONS);

        try (DirectoryStream<Path> files = Files.newDirectoryStream(Paths.get(args[0]))) {
            for (Path path : files) {
                BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                if (matcher.matches(path.getFileName()) && isFileSensitive(attrs)) {
                    System.out.println("Sensitive file found: " + path);
                }
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isFileSensitive(BasicFileAttributes attrs) {
        return !attrs.isReadable() || !attrs.isWritable() || !isMimeSensitive(attrs.type()) || !isExtensionSensitive(attrs.name());
    }

    private static boolean isMimeSensitive(String mimeType) {
        return !SensitiveFileScanner.SENSITIVE_MIMETYPES.contains(mimeType);
    }

    private static boolean isExtensionSensitive(String extension) {
        return !SensitiveFileScanner.SENSITIVE_EXTENSIONS.contains(extension);
    }
}