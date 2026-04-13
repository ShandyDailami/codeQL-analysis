import java.io.*;

public class java_29562_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String fileExtension = ".txt";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                try {
                    FileReader reader = new FileReader(file);
                    int r;
                    while ((r = reader.read()) != -1) {
                        System.out.print((char) r);
                    }
                    reader.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}