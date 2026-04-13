import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14214_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234); // Listening port
            System.out.println("Server started at port 1234");

            while (true) {
                Socket socket = server.accept();
                System.out.println("A client connected");

                // Here, we're only using the socket to send and receive data.
                // This is a simple example and not a secure one.
                // In real applications, you would use a SecureSocket and a BufferedReader
                // to handle data received from the client.

                String clientMessage = socket.getInputStream().readUTF();
                System.out.println("Client message: " + clientMessage);

                String responseMessage = "Server received your message";
                socket.getOutputStream().writeUTF(responseMessage);
                socket.getOutputStream().flush();
                System.out.println("Server response: " + responseMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}