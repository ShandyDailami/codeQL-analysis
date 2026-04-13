import java.io.*;

public class java_26128_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            // Use a valid directory path for testing
            File dir = new File("C:\\testdir");
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // Use only standard libraries
                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);

                        String line;
                        while ((line = br.readLine()) != null) {
                            // Use only standard libraries
                            System.out.println(line);
                       
                        }

                        br.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}