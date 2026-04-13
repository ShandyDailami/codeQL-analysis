import java.io.*;

public class java_05013_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/main/resources/");

        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File f : listFiles) {
                if (f.isFile() && f.canRead()) {
                    readFile(f);
                }
            }
        }
    }

    private static void readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            // handle line
        }
        reader.close();
    }
}