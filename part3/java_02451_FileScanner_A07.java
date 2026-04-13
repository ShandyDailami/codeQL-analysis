import java.io.*;

public class java_02451_FileScanner_A07 {
    public static void main(String[] args) {
        String dir = "/path/to/directory";

        File f = new File(dir);
        File[] files = f.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    FileReader fr = null;
                    BufferedReader br = null;
                    try {
                        fr = new FileReader(file);
                        br = new BufferedReader(fr);

                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (br != null) br.close();
                            if (fr != null) fr.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}