import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_23397_FileScanner_A07 {

    private static final String DENIED_EXTENSIONS = ".exe, .dll, .jar, .class";

    public Set<String> findDeniedExtensions(File directory) {
        Set<String> deniedExtensions = new HashSet<>();
        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                if (file != null && file.isFile() && isDeniedExtension(file.getName())) {
                    deniedExtensions.add(file.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deniedExtensions;
    }

    private boolean isDeniedExtension(String fileName) {
        return DENIED_EXTENSIONS.contains(fileName.toLowerCase());
    }

    public static void main(String[] args) {
        AuthFailureScanner scanner = new AuthFailureScanner();
        File directory = new File(".");
        Set<String> deniedExtensions = scanner.findDeniedExtensions(directory);
        if (deniedExtensions.isEmpty()) {
            System.out.println("No denied extensions found.");
        } else {
            System.out.println("Denied extensions: " + deniedExtensions);
        }
    }
}