import java.io.*;

public class java_42096_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.canRead() && file.length() < 1000) {
                    try (FileReader reader = new FileReader(file)) {
                        int r;
                        while ((r = reader.read()) != -1) {
                            System.out.print((char) r);
                        }
                        System.out.println("\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}