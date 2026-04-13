import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38852_SocketServer_A07 {

    private static final String PASSWORD = "password";
    private static final String USERNAME = "username";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(54321); // port number
            System.out.println("Server started, waiting for client connections...");

            socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Read and validate username and password
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientInput = reader.readLine();
            String[] clientInfo = clientInput.split(" ");

            if (!clientInfo[0].equals(USERNAME) || !clientInfo[1].equals(PASSWORD)) {
                System.out.println("Authentication failed!");
                socket.close();
                serverSocket.close();
            } else {
                System.out.println("Authentication successful!");
                // Proceed with communication or other operations
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { /* can't do anything */ }
            }
            if (socket != null) {
                try { socket.close(); } catch (IOException e) { /* can't do anything */ }
            }
        }
    }
}