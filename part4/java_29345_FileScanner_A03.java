import java.io.*;

public class java_29345_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\User\\Desktop\\test.txt");

        if (file.exists()) {
            FileReader reader = new FileReader(file);
            int character;

            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }

            reader.close();
        } else {
            System.out.println("File does not exist");
        }
    }
}