import java.io.*;

public class java_12489_FileScanner_A03 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("target/file.txt")) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            String targetString = "A03_Injection";
            StringBuilder content = new StringBuilder();

            while ((bytesRead = fis.read(buffer)) != -1) {
                content.append(new String(buffer, 0, bytesRead));
            }

            if (content.toString().contains(targetString)) {
                System.out.println("String is present in the file.");
            } else {
                System.out.println("String is not present in the file.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}