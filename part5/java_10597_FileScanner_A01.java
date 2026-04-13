import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecurityPermission;

public class java_10597_FileScanner_A01 {
    public static void main(String[] args) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new SecurityPermission("control.FileInputStream"));
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}