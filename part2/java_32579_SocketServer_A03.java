import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32579_SocketServer_A03 {

    private ServerSocket serverSocket;

    public java_32579_SocketServer_A03(int port) {
        try {
            serverSocket = new ServerSocket(port, 0, InetAddress.getByName("localhost"));
            System.out.println("Server is listening on port " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listenForClients() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");
                handleClient(clientSocket);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void handleClient(Socket clientSocket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received message: " + clientMessage);

                // Simple Injection prevention
                // This is just a simple example and actual injection could be more complex.
                // In this case, the message will be directly sent back to the client.
                out.println("Echo: " + clientMessage);

                // If client says 'exit', server will close connection.
                if (clientMessage.equals("exit")) {
                    System.out.println("Closing connection with client");
                    clientSocket.close();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SocketServer(54321).listenForClients();
    }
}