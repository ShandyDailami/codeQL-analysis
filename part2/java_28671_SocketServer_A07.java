import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_28671_SocketServer_A07 {
    private static final String CLIENT_AUTH_KEY = "clientAuthKey";
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {
        ServerSocket socket = null;
        try {
            socket = (ServerSocket) new SSLServerSocket(12345, null, null, SSLServerSocket.getSupportedProtocols());
            System.out.println("Server started");
            while (true) {
                SSLSocket clientSocket = (SSLSocket) socket.accept();
                System.out.println("Client accepted");
                handleClient(clientSocket);
            }
        } catch (IOException ex) {
            System.out.println("Server could not listen on port 12345");
            System.exit(-1);
        } finally {
            socket.close();
        }
    }

    private static void handleClient(SSLSocket clientSocket) {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            System.out.println("Handshake");
            SSLHandshake handshake = new SSLHandshake(clientSocket);
            handshake.process();
            System.out.println("Handshake completed");
            if (handshake.getState() == SSLHandshake.HANDSHAKE_SUCCESS) {
                System.out.println("Client authentication successful");
                out.println("Client authentication successful");
                String clientInput;
                while ((clientInput = in.readLine()) != null) {
                    System.out.println("Received: " + clientInput);
                    if ("exit".equals(clientInput)) {
                        out.println("Goodbye!");
                        break;
                    }
                    out.println("Server received: " + clientInput);
                }
            } else {
                System.out.println("Client authentication failed");
                out.println("Client authentication failed");
            }
        } catch (IOException ex) {
            System.out.println("Error with client");
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                clientSocket.close();
            } catch (IOException ex) {
                System.out.println("Error closing client connection");
            }
        }
    }
}