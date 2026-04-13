import java.io.*;

public class java_00883_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        File directory = new File(".");
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                FileReader reader = new FileReader(txtFile);
                int character;

                while ((character = reader.read()) != -1) {
                    System.out.print((char) character);
                }

                reader.close();
            }
        }
    }
}