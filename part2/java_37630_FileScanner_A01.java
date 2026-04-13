import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_37630_FileScanner_A01 {

    public static void main(String[] args) {
        File currentDir = new File(".");
        String[] txtFiles = currentDir.list(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        if (txtFiles != null) {
            Arrays.sort(txtFiles);
            for (String txtFile : txtFiles) {
                System.out.println("Reading " + txtFile);
                // Replace this with the actual reading and processing of the file.
                readAndProcessFile(txtFile);
            }
        }
    }

    private static void readAndProcessFile(String txtFile) {
        // Placeholder for actual reading and processing of the file.
        // For demonstration purposes, this method will print the filename.
        System.out.println("Processing " + txtFile);
    }
}