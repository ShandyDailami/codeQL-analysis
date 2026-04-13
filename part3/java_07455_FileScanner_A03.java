import java.io.File;
import java.security.CodeSigner;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;

public class java_07455_FileScanner_A03 implements FileFilter {

    private String[] allowedExtensions = { "txt", "pdf", "docx" };

    @Override
    public boolean accept(File path) {
        if (path.isDirectory()) {
            return false;
        }

        String name = path.getName();
        int lastDot = name.lastIndexOf('.');
        if (lastDot == -1) {
            return false;
        }

        String extension = name.substring(lastDot + 1);
        for (String allowedExtension : allowedExtensions) {
            if (allowedExtension.equals(extension)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        InsecureFileScanner scanner = new InsecureFileScanner();

        File rootDirectory = new File(".");
        File[] hiddenFiles = rootDirectory.listFiles(file -> file.isHidden());
        if (hiddenFiles != null) {
            Arrays.stream(hiddenFiles).forEach(System.out::println);
        }

        File[] allFiles = rootDirectory.listFiles(scanner);
        if (allFiles != null) {
            Arrays.stream(allFiles).forEach(System.out::println);
        }
    }
}