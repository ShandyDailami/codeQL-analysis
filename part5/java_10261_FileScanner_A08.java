import java.io.*;
import java.nio.file.*;
import java.security.*;

public class java_10261_FileScanner_A08 {
    private static final String FILE_NAME = "targetFile.txt";

    public static void main(String[] args) {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                if (file.canRead()) {
                    scanFileForKeyword(file);
                } else {
                    System.out.println("Error: The file cannot be read.");
                }
            } else {
                System.out.println("Error: The file does not exist.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void scanFileForKeyword(File file) throws IOException {
        String keyword = "integrityFailure";
        boolean foundKeyword = false;

        FileReader reader = new FileReader(file);
        int c;

        while ((c = reader.read()) != -1) {
            if (c == keyword.charAt(0)) {
                foundKeyword = true;
                for (int i = 1; i < keyword.length(); i++) {
                    if (c != keyword.charAt(i)) {
                        foundKeyword = false;
                        break;
                    }
                    c = reader.read();
                }
            }
            if (foundKeyword) {
                System.out.println("Keyword found in file: " + file.getPath());
            }
        }
        reader.close();
    }
}