import java.io.*;
import java.net.*;

public class java_29920_SocketServer_A07 {
    private static final String AUTHENTICATION_SUCCESS = "Authentication successful!";
    private static final String AUTHENTICATION_FAILURE = "Authentication failure!";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // For authenticating, this is a simple check
                if (authenticateClient(socket)) {
                    handleClient(socket);
                } else {
                    sendResponse(socket, AUTHENTICATION_FAILURE);
                }
           
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean authenticateClient(Socket socket) {
        // Here we can use a more complex method to authenticate the client.
        // For simplicity, we are checking if the client is still connected after the handshake.
        return socket.isConnected();
    }

    private static void handleClient(Socket socket) {
        try (OutputStream out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             InputStream in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.write(AUTHENTICATION_SUCCESS.getBytes());
            out.newLine();
            out.flush();

            int bytes;
            while ((bytes = in.read()) != -1) {
                System.out.print((char) bytes);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendResponse(Socket socket, String response) {
        try (OutputStream out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.write(response.getBytes());
            out.newLine();
            out.flush();

            int bytes;
            while ((bytes = in.read()) != -1) {
                System.out.print((char) bytes);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}