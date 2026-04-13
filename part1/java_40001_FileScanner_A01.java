import java.io.*;

public class java_40001_FileScanner_A01 {
    private static final String DIRECTORY = "/path/to/directory";
    private static final String FILE_PATTERN = "*.txt";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] files = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().matches(FILE_PATTERN);
            }
        });

        if (files != null) {
            for (File file : files) {
                try {
                    FileReader reader = new FileReader(file);
                    int c;

                    while ((c = reader.read()) != -1) {
                        System.out.print((char) c);
                    }

                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}