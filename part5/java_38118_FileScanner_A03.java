import java.io.*;

public class java_38118_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        File file = new File("directory_path"); // replace with your directory path
        File[] list = file.listFiles();

        if (list != null) {
            for (File f : list) {
                if (f.isFile() && f.canRead()) {
                    System.out.println("Reading file: " + f.getName());
                    FileReader reader = new FileReader(f);
                    int data = reader.read();

                    while (data != -1) {
                        System.out.print((char) data);
                        data = reader.read();
                   
                    }
                    reader.close();
                }
            }
        }
    }
}