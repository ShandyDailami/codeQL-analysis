import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24229_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 5000; // listen on port 5000

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());

                    // wrap the socket in a BufferedReader
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    // wrap the socket in a PrintWriter
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                    // send a greeting to the client
                    out.println("Hello, client!");

                    // receive and print a line from the client
                    String greeting = in.readLine();
                    System.out.println("Received: " + greeting);

                    // close the socket and resources
                    socket.close();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}