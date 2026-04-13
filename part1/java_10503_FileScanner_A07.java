import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_10503_FileScanner_A07 {
    public static void main(String[] args) {
        // Specify the directory to scan
        File dir = new File(".");

        // Create a FilenameFilter that only accepts .txt files
        FilenameFilter txtFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        // Use the File and FilenameFilter API to scan the directory
        File[] txtFiles = dir.listFiles(txtFilter);
        if (txtFiles != null) {
            Arrays.stream(txtFiles).forEach(AuthFailureScanner::scanFile);
        }
    }

    private static void scanFile(File file) {
        // Put your security-sensitive operations here, like checking if the file contains a certain string
        // For example, we'll check if the file contains the string "AuthFailure"
        try {
            if (file.exists() && file.canRead()) {
                byte[] data = new byte[(int) file.length()];
                FileReader reader = new FileReader(file);
                reader.read(data);
                String strData = new String(data);
                if (strData.contains("AuthFailure")) {
                    System.out.println("File " + file.getName() + " contains the string 'AuthFailure'");
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file " + file.getName());
        }
    }
}