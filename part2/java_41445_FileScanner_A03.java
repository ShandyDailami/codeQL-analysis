import java.io.*;
import java.net.*;

public class java_41445_FileScanner_A03 {
    public static void main(String[] args) {
        String dir = "/path/to/directory"; // Replace with your directory path
        File f = new File(dir);

        File[] files = f.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && !file.getName().contains("EchoServer")) {
                    try {
                        FileReader reader = new FileReader(file);
                        BufferedReader br = new BufferedReader(reader);
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                       
                        }
                        br.close();
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }
        }
    }
}