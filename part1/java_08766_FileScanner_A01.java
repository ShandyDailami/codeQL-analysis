import java.io.*;

public class java_08766_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] list = directory.list();
        if (list == null) {
            System.out.println("No files or directories found.");
            return;
        }
        for (String filename : list) {
            File file = new File(filename);
            if (file.isFile() && file.canRead()) {
                try {
                    FileReader reader = new FileReader(file);
                    int r;
                    while ((r = reader.read()) != -1) {
                        System.out.print((char) r);
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}