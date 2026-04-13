import java.io.*;

public class java_34011_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\path\\to\\directory");
            File[] files = file.listFiles();
            
            for (File f : files) {
                if (f.getName().endsWith(".txt")) {
                    FileReader reader = new FileReader(f);
                    int ch;
                    while ((ch = reader.read()) != -1) {
                        System.out.print((char) ch);
                   
                    }
                    reader.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}