import java.io.*;

public class java_12940_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (FileReader reader = new FileReader(file)) {
                        int character;
                        while ((character = reader.read()) != -1) {
                            System.out.print((char) character);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println();
                }
            }
        }
    }
}