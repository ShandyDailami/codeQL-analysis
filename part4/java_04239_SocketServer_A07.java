import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04239_SocketServer_A07 {
    private static final String SERVER_MSG = "Welcome back!";

    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started on port 1234");

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Get the output stream from the client
                OutputStream outToClient = clientSocket.getOutputStream();
                outToClient.writeUTF(SERVER_MSG);

                // Close the connection
                clientSocket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}