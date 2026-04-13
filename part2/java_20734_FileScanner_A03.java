import java.io.*;

public class java_20734_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "C:\\path\\to\\directory"; // provide your directory path
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        FileReader reader = new FileReader(file);
                        int character;

                        while ((character = reader.read()) != -1) {
                            System.out.print((char) character);
                        }

                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}