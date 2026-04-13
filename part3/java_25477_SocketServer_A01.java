import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class java_25477_SocketServer_A01 {
    private int port;
    private ServerSocket serverSocket;

    public java_25477_SocketServer_A01(int port) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);

                // Implement your security sensitive operations here, e.g.
                // if client sends a command to access unauthorized resources, deny the connection.
                if (inputLine.equals("deny")) {
                    out.println("Access denied");
                } else {
                    out.println("Access granted");
                }
            }

            clientSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(8080);
        server.startServer();
    }
}