import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33363_SocketServer_A03 {

    public static void main(String[] args) {
        // Create a server socket
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server started!");
        } catch (IOException e) {
            e.printStackTrace();
       
        }

        // Wait for client connection
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                // Create input and output streams
                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();

                // Authenticate the client
                String auth = "User1";  // This should be a more secure way to authenticate
                if (authenticate(input, output, auth)) {
                    // Client is authenticated, handle communication
                    handleCommunication(socket);
                } else {
                    System.out.println("Authentication failed!");
                    socket.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean authenticate(InputStream input, OutputStream output, String auth) {
        // Implement authentication here. Here we just check if the user is "User1"
        // Replace with a more secure way to authenticate
        try {
            // Send authentication response
            output.write((auth + "\n").getBytes());
            output.flush();

            // Read response from client
            byte[] buffer = new byte[256];
            int bytesRead = input.read(buffer);
            String response = new String(buffer, 0, bytesRead);

            // Authentication successful if response is "OK"
            return response.equals("OK");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static void handleCommunication(Socket socket) {
        // Implement communication handler here
        // This is a simple echo server
        try {
            byte[] buffer = new byte[256];
            int bytesRead;
            while ((bytesRead = socket.getInputStream().read(buffer)) != -1) {
                socket.getOutputStream().write(buffer, 0, bytesRead);
                socket.getOutputStream().flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}