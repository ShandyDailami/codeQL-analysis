import java.io.*;
import java.net.*;
import java.util.*;

public class java_25527_SessionManager_A07 {
    private static final String SERVER_URL = "http://localhost:8080/auth";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        // Create a post request
        String request = "username=" + username + "&password=" + password;
        HttpURLConnection conn = (HttpURLConnection) new URL(SERVER_URL).openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        // Send request to server
        OutputStream outputStream = conn.getOutputStream();
        outputStream.write(request.getBytes());
        outputStream.flush();

        // Get response from server
        InputStream inputStream = conn.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String responseLine;
        StringBuilder response = new StringBuilder();

        while ((responseLine = reader.readLine()) != null) {
            response.append(responseLine);
        }

        reader.close();

        // Print response
        System.out.println("Response: " + response.toString());

        conn.disconnect();
    }
}