import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_18968_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        // Creating the server socket
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        try {
            // Check if the server is an SSL server
            if (args[0].equals("-ssl")) {
                sslServerSocket = (SSLServerSocket) serverSocket = new SSLServerSocket(12345);
                sslServerSocket.setEnabledSSLProtocols(new String[]{"TLSv1.2"});
            } else {
                serverSocket = new ServerSocket(12345);
            }

            System.out.println("Server started with port number: " + serverSocket.getLocalPort());

            while (true) {
                // Waiting for client connection
                SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
                System.out.println("Client connected");

                // Creating buffered reader and output stream
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                OutputStream out = clientSocket.getOutputStream();

                // Receiving data from the client
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received message: " + inputLine);

                    // Sending back the received data
                    out.write(inputLine.toUpperCase().getBytes());
                    out.newLine();
                    out.flush();
                }

                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Closing the server socket
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}