import java.io.*;
import java.net.*;
import java.util.*;

public class java_22381_SocketServer_A08 {
    private static final String CRLF = "\r\n";
    private static final String LOOPBACK = "127.0.0.1";
    private static final String INTERFACE = "localhost";
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(PORT));

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            // Perform integrity check
            if (!performIntegrityCheck(socket)) {
                System.out.println("Integrity failure detected, closing connection");
                socket.close();
                continue;
            }

            // Handle request
            handleRequest(socket);

            socket.close();
        }
    }

    private static boolean performIntegrityCheck(Socket socket) throws IOException {
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Send a request
        out.writeUTF("Hello, client!");
        out.flush();

        // Receive a response
        String response = in.readUTF();
        System.out.println("Received response: " + response);

        // Close the connection
        socket.close();

        // Perform integrity check
        Socket newSocket = new Socket(INTERFACE, PORT);
        newSocket.connect(new InetSocketAddress(LOOPBACK, PORT));
        newSocket.close();

        // Compare the response with the received response
        return response.equals("Hello, client!");
    }

    private static void handleRequest(Socket socket) throws IOException {
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Receive a request
        String request = in.readUTF();
        System.out.println("Received request: " + request);

        // Send a response
        out.writeUTF("Thanks, client!");
        out.flush();
    }
}