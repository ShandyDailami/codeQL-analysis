import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

public class java_31068_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        File file = new File(".");
        String[] textFiles = file.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });

        if (textFiles != null) {
            Arrays.sort(textFiles);
            for (String txtFile : textFiles) {
                System.out.println(txtFile);
            }
        } else {
            System.out.println("No .txt files found in current directory.");
        }
    }

}