import java.io.File;
import java.lang.reflect.Method;

public class java_25970_FileScanner_A01 {

    // Define the file and directory to bypass
    private static final String FILE_TO_SCAN = "C:\\Windows\\system32\\config\\systemprofile";
    private static final String DIRECTORY_TO_SCAN = "C:\\Windows\\system32";

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();

        try {
            // Execute bypass method
            Method method = FileScanner.class.getDeclaredMethod("bypassFileAccess", File.class);
            method.setAccessible(true);
            method.invoke(scanner, new File(FILE_TO_SCAN));
            method.invoke(scanner, new File(DIRECTORY_TO_SCAN));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bypassFileAccess(File file) {
        if (file.canRead()) {
            System.out.println("File can be read: " + file.getAbsolutePath());
        } else {
            System.out.println("File cannot be read: " + file.getAbsolutePath());
        }

        if (file.canWrite()) {
            System.out.println("File can be written: " + file.getAbsolutePath());
        } else {
            System.out.println("File cannot be written: " + file.getAbsolutePath());
        }

        if (file.isDirectory()) {
            System.out.println("Directory: " + file.getAbsolutePath());

            for (File innerFile : file.listFiles()) {
                bypassFileAccess(innerFile);
            }
        }
    }
}