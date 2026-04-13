import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;

public class java_15982_CredentialValidator_A01 {

    public void checkAccess() {
        try {
            URL url = new URL("http://example.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                System.out.println("Access granted to URL");
            } else {
                System.out.println("Access denied to URL");
            }
            
            connection.disconnect();
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL");
        } catch (IOException e) {
            System.out.println("Error accessing URL");
        }
    }
}