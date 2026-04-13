import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_37651_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket socketserver = new ServerSocket(12345);
        SSLServerSocket sslServerSocket = (SSLServerSocket) socketserver;

        System.out.println("Waiting for client on port: " + sslServerSocket.getLocalPort());

        // Create an SSLServerSocket and wrap it with SSLSocket
        SSLServerSocket sslServer = (SSLServerSocket) sslServerSocket;
        SSLSocket socket = (SSLSocket) sslServer.accept();
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Create a BufferedReader for the socket input stream
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String inputLine;

        // Wait for client data
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            out.println("Server: " + inputLine);
       
            if (inputLine.equals("close")) {
                break;
            }
        }

        socket.close();
        sslServer.close();
        socketserver.close();
    }
}