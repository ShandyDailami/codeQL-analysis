import java.io.File;
import java.io.FileFilter;

public class java_31617_FileScanner_A01 {

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        String extension = ".*.java";

        fileScan(rootDirectory, extension);
    }

    private static void fileScan(File root, String extension) {
        File[] foundFiles = root.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        for (File file : foundFiles) {
            readFile(file);
        }
    }

    private static void readFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}