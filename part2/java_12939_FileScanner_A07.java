import java.io.*;

public class java_12939_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
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
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getPath());
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + file.getPath());
                    }
                }
            }
        }
    }
}