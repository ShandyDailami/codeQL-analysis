import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25067_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Create a server socket and wait for a client to connect
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("Server is listening on port 6666");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Handle client's request
            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("Received: " + request);
                if ("quit".equals(request)) {
                    out.println("Server is shutting down");
                    socket.close();
                    serverSocket.close();
                    break;
                } else {
                    out.println("Echo: " + request);
                }
            }
        }
    }
}