import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_29305_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Create a SSLServerSocket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuthentication(true);

            // Accept a client connection
            clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            // Create input and output streams
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Create a handler thread for the client
            HandlerThread handlerThread = new HandlerThread("SocketServer-inbound-handler");
            handlerThread.start();

            // Create a socket server handler
            SocketServerHandler handler = new SocketServerHandler(clientSocket, out, in, handlerThread.getLooper());

            // Handle the client connection in the handler thread
            handlerThread.getQueue().add(handler);

            // Send a message to the client
            out.println("Hello Client, you connected to the Socket Server!");

            // Keep the connection open
            while (true) {
                String message = in.readLine();
                if (message == null) break;
                System.out.println("Received: " + message);
           
                // Echo back the message
                out.println(message);
            }
        } finally {
            // Close the connection
            if (clientSocket != null) clientSocket.close();
            if (serverSocket != null) serverSocket.close();
        }
    }
}