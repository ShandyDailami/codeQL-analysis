import java.io.*;

public class java_14348_FileScanner_A01 {
    private static final String DIRECTORY = "/path/to/directory";
    private static final String FILE_PATTERN = "*.txt";

    public static void main(String[] args) throws IOException {
        File dir = new File(DIRECTORY);
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().matches(FILE_PATTERN);
            }
        });

        for (File file : files) {
            printFilePermissions(file);
        }
    }

    private static void printFilePermissions(File file) throws IOException {
        FileReader reader = new FileReader(file);
        int c;

        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }

        reader.close();
    }
}