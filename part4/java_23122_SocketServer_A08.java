import java.net.ServerSocket;
import java.net.Socket;

public class java_23122_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        // Step 1: Setup a ServerSocket
        ServerSocket server = new ServerSocket(1234); // the port number to be used
        System.out.println("Server is listening on port 1234");

        // Step 2: Wait for a client to connect
        Socket socket = server.accept();
        System.out.println("Client has connected");

        // Step 3: Handle the communication
        // Here we're assuming that the client sends a message, and then responds with another message
        // However, in a real-world application, you'd typically read a command from the client, perform some kind of operation, and then send a response back

        // Step 4: Close the connection
        socket.close();
        server.close();
    }
}