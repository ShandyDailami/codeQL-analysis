import java.io.*;

public class java_01324_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        String dirPath = "path_to_your_directory"; // replace with your directory path
        scanDirectory(new File(dirPath));
    }

    public static void scanDirectory(File dir) throws IOException {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.isFile()) {
                    processFile(file);
                }
            }
        }
    }

    public static void processFile(File file) throws IOException {
        FileReader reader = new FileReader(file);
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1) {
            sb.append((char) c);
        }
        String content = sb.toString();
        content = content.replace("IntegrityFailure", "REDACTED");
        if (!content.equals(sb.toString())) {
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        }
        reader.close();
    }
}