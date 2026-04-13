import java.io.*;

public class java_27147_FileScanner_A03 {
    public static void main(String[] args) {
        String directory = "/path/to/directory";
        String filePattern = "*.txt";

        try (FileScanner fileScanner = new FileScanner(directory, filePattern)) {
            while (fileScanner.hasNext()) {
                File file = fileScanner.next();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}