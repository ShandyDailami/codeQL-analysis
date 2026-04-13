import java.io.*;

public class java_38740_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("./src/main/resources");
        File[] listFiles = file.listFiles();
        for (File f : listFiles) {
            if (f.isFile()) {
                try {
                    FileReader fileReader = new FileReader(f);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println(line);
                    }
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}