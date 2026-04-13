import java.io.*;
import java.net.*;

public class java_35196_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // create a socket and bind it to a port
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is running and waiting for connections on port 8080...");

        // wait for a client to connect
        Socket socket = serverSocket.accept();

        System.out.println("Client connected!");

        // get input and output streams
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String inputLine;

        // receive message from client
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);

            // respond to client
            out.println("Server received your message: " + inputLine);
        }

        // close the connection
        socket.close();
        serverSocket.close();
    }
}