import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19177_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // create a server socket at port 8080
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started. Waiting for client on port 8080...");

            while (true) {
                // wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // get the input and output streams from the socket
                InputStream input = clientSocket.getInputStream();
                OutputStream output = clientSocket.getOutputStream();

                // handle the client by reading and writing data
                byte[] buffer = new byte[1024];
                int bytesRead = input.read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received message: " + message);

                // send a response back to the client
                String response = "Hello, Client!";
                output.write(response.getBytes());
                System.out.println("Sent response: " + response);

                // close the connection
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}