import java.io.*;

public class java_35060_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        File file = new File("/path/to/directory");
        File[] list = file.listFiles();
        
        if (list != null) {
            for (File f : list) {
                if (f.isFile() && f.length() > 0) {
                    FileReader reader = new FileReader(f);
                    int r;
                    while ((r = reader.read()) != -1) {
                        if (r == 'A' || r == 'a' || r == '0') {
                            System.out.println("Detected file integrity failure at: " + f.getPath());
                        }
                    }
                    reader.close();
                }
            }
        }
    }
}