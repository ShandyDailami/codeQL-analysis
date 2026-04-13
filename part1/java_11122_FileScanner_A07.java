import java.io.*;

public class java_11122_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        File directory = new File(".");
        String[] files = directory.list();

        for (String file : files) {
            if (file.endsWith(".txt")) {
                FileReader reader = new FileReader(file);
                int ch;

                while ((ch = reader.read()) != -1) {
                    System.out.print((char) ch);
                }

                reader.close();
            }
        }
    }
}