import java.io.*;
import java.net.*;

public class java_11143_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // open a port
        while (true) {
            Socket socket = server.accept(); // accept a client connection

            // create streams from socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // read a request
            String request = in.readLine();
            out.println("Hello, you said: " + request);
        }
    }
}