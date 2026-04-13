import java.io.*;

public class java_06807_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        File file = new File(".");

        File[] list = file.listFiles();

        if (list != null) {
            for (File f : list) {
                if (f.isFile() && f.getName().endsWith(".txt")) {
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);

                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }

                    br.close();
                    fr.close();
                }
            }
        }
    }
}