import java.io.*;

public class java_32394_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        File file = new File(".");
        scanDirectory(file);
    }

    public static void scanDirectory(File directory) throws IOException {
        File[] files = directory.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                scanDirectory(file);
            } else {
                printFileContent(file);
            }
        }
    }

    public static void printFileContent(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}