import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10472_SocketServer_A03 {

    public static void main(String[] args) {
        int port = 12345; // choose a port number
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(port); // create a new server socket
            System.out.println("Server started, waiting for client connection on port " + port);

            socket = serverSocket.accept(); // wait for client connection
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            // create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // read from the client
            String message = in.readLine();
            System.out.println("Client says: " + message);

            // send a response
            out.println("Hello, client!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}