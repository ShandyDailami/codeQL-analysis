import java.io.*;
import java.net.*;

public class java_21769_SocketServer_A01 {
    private static final int PORT = 8080;
    private static final String SAFE_HOST = "127.0.0.1";
    private static final int SAFE_PORT = 8081;
    private static Socket safeSocket;

    public static void main(String[] args) {
        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            // Create safe client socket
            safeSocket = new Socket(SAFE_HOST, SAFE_PORT);

            // Get the output stream from the safe socket
            out = new PrintWriter(safeSocket.getOutputStream(), true);

            // Get the input stream from the safe socket
            in = new BufferedReader(new InputStreamReader(safeSocket.getInputStream()));

            // Send a message to the safe server
            out.println("Hello, Server!");

            // Wait for a response
            String response = in.readLine();
            System.out.println("Server Response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (out != null) out.close();
                if (in != null) in.close();
                if (clientSocket != null) clientSocket.close();
                if (safeSocket != null) safeSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}