import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02190_SocketServer_A01 {
    private static final int PORT = 6000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client " + clientSocket.getRemoteSocketAddress() + " connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String request;
            while ((request = in.readLine()) != null) {
                if (request.equalsIgnoreCase("QUIT")) {
                    out.println("Server successfully closed connection from " + clientSocket.getRemoteSocketAddress());
                    clientSocket.close();
                    System.out.println("Connection from " + clientSocket.getRemoteSocketAddress() + " closed");
                    break;
                } else {
                    out.println("Received: " + request);
                    if (request.startsWith("BAN")) {
                        out.println("Access Denied for client " + clientSocket.getRemoteSocketAddress());
                    } else {
                        out.println("Access Granted for client " + clientSocket.getRemoteSocketAddress());
                    }
                }
            }
            out.close();
            clientSocket.close();
        }
    }
}