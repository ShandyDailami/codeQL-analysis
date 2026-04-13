import java.io.*;
import java.util.*;

public class java_34803_FileScanner_A07 {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\username\\Downloads");
        File[] content = f.listFiles();

        for (File file : content) {
            if (file.isFile()) {
                try {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (line.contains("A07_AuthFailure")) {
                            System.out.println("Found the line: " + line);
                        }
                    }
                    br.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}