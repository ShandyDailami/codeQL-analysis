import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01526_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello, Client, you connected to the server!");

            // Read the incoming request
            String request = socket.getInputStream().readUTF();
            System.out.println("Received request: " + request);

            // Process the request (in this case, just echo it back)
            out.println("Server: " + request);
       
            // Close the connection
            socket.close();
        }
    }
}