import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_17557_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        // Create a SSLServerSocket for the server to listen on port 8888
        SSLServerSocket server = new SSLServerSocket(8888, null, null,
                SSLServerSocket.getDefaultSSLSocketFactory());

        while (true) {
            try {
                // accept a connection
                clientSocket = (SSLSocket) server.accept();
                System.out.println("Client connected");
                // Get the input and output streams
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // Get the request
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Server received: " + inputLine);
                    out.println("Server received: " + inputLine);
                    if (inputLine.equals("exit")) {
                        server.close();
                        clientSocket.close();
                        System.out.println("Connection closed");
                        break;
                    }
                }
                // Close the connection
                server.close();
                clientSocket.close();
                System.out.println("Connection closed");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}