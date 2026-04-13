import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34786_SocketServer_A01 {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public java_34786_SocketServer_A01(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);

                // Simulate a security breach
                // If the client sends a specific command, the server will respond with a message
                if (inputLine.equalsIgnoreCase("BREACH")) {
                    out.println("Access Denied");
                    System.out.println("Access Denied");
                } else {
                    out.println("Server accepted the connection");
                    System.out.println("Server accepted the connection");
                }
            }

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SocketServer(5000);
    }
}