import java.io.*;
import java.net.*;

public class java_39608_SocketServer_A01 {

    private static final String AUTH_REQ = "Authorization";
    private static final String AUTH_RESP = "Basic " + Base64.getEncoder().encodeToString("username:password".getBytes());

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            try {
                Socket socket = server.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Send authentication request
                out.writeBytes(AUTH_REQ + "\r\n\r\n");

                // Receive authentication response
                String response = in.readLine();
                if (response.equals(AUTH_RESP)) {
                    System.out.println("Authentication successful");
                    // Continue communication if authentication is successful
                    out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
                } else {
                    System.out.println("Authentication failed");
                    out.writeBytes("HTTP/1.1 401 Unauthorized\r\n\r\n");
               
                }
                out.flush();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}