import java.io.*;

public class java_28117_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/your/file.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}