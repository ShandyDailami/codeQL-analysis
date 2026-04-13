import java.io.*;

public class java_01131_FileScanner_A07 {
    public static void main(String[] args) {
        File dir = new File(".");
        String[] files = dir.list();

        for (String fileName : files) {
            File file = new File(fileName);
            if (file.canRead() && !file.isDirectory()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    int lineNumber = 0;
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lineNumber++;
                        // This is a placeholder for the code that handles security-sensitive operations related to A07_AuthFailure.
                        // It's not actual code, it's just a placeholder.
                        // The actual code should handle the security-sensitive operations related to A07_AuthFailure.
                        if (line.contains("authFailure")) {
                            System.out.println("Line: " + lineNumber + ", Contents: " + line);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}