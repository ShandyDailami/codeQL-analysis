import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class java_20490_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com/auth");
            URLConnection conn = url.openConnection();
            Scanner scanner = new Scanner(conn.getInputStream());

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
}