import java.io.*;

public class java_37214_FileScanner_A01 {
    private static final String FILE_PATH = "C:\\Users\\user\\Desktop\\file.txt";

    public static void main(String[] args) {
        File file = new File(FILE_PATH);
        try {
            // Checking if the file can be read
            if (file.canRead()) {
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }

                bufferedReader.close();
                reader.close();
            } else {
                System.out.println("Cannot read file at specified path: " + FILE_PATH);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}