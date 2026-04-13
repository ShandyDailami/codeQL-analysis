import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class java_14811_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // This filter will only accept .txt files
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        File[] files = directory.listFiles(fileFilter);
        if (files != null) {
            for (File file : files) {
                readFileContent(file);
            }
        }
    }

    private static void readFileContent(File file) throws IOException {
        if (file.canRead()) {
            // Read the content of the file
            byte[] fileContent = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            fis.read(fileContent);
            fis.close();

            // Convert the bytes to a string
            String content = new String(fileContent);

            // Print the content
            System.out.println("Content of file: " + content);
        } else {
            System.out.println("Cannot read the file: " + file.getPath());
        }
    }
}