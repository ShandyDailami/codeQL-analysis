import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_37870_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        boolean useSsl = true;

        if (useSsl) {
            SSLServerSocket serverSocket = null;
            try {
                serverSocket = (SSLServerSocket) new SSLServerSocket(port);
                System.out.println("Server started with port: " + port);
            } catch (IOException ex) {
                System.out.println("Could not listen on port: " + port);
                System.exit(-1);
            }

            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Connection established with client: " + clientSocket.getRemoteSocketAddress());
            } catch (IOException ex) {
                clientSocket.close();
            }

            // Send a response to the client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hello, client!");
        } else {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started with port: " + port);

            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection established with client: " + clientSocket.getRemoteSocketAddress());

            // Read the request from the client and print the response
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
            }
        }
    }
}