import java.io.*;

public class java_23197_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
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
                        System.out.println();
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + file.getAbsolutePath());
                    }
                }
            }
        }
    }
}