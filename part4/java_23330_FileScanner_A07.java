import java.io.*;

public class java_23330_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File(".");
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    try {
                        FileReader reader = new FileReader(f);
                        int i;
                        while ((i = reader.read()) != -1) {
                            System.out.print((char) i);
                       
                        }
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (f.isDirectory()) {
                    System.out.println("<DIR> " + f.getName());
                }
            }
        }
    }
}