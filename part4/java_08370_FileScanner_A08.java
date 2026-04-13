import java.io.File;
import java.util.Arrays;

public class java_08370_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                Arrays.stream(files)
                      .filter(file -> file.isFile() && file.getName().endsWith(".txt"))
                      .forEach(file -> {
                          try {
                              ScanFile(file);
                          } catch (Exception e) {
                              e.printStackTrace();
                          }
                      });
            }
        }
    }

    public static void ScanFile(File file) {
        try {
            // Read file content using FileReader
            java.io.FileReader fr = new java.io.FileReader(file);
            char[] charArray = new char[(int) file.length()];

            // read file content into buffer
            fr.read(charArray);

            // print buffer
            System.out.println(new String(charArray));

            // close the reader
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}