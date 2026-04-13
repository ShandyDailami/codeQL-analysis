import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17001_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234); // open port 1234
        System.out.println("Waiting for connection...");

        while (true) {
            Socket socket = server.accept(); // wait for client connection
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) { // read client message
                System.out.println("Received: " + message);
                out.println("Hello, client, I received your message");
            }

            socket.close();
        }
    }
}