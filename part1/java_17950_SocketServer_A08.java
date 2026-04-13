import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class java_17950_SocketServer_A08 {

    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static PrintWriter out;
    private static BufferedReader in;

    public static void main(String[] args) throws IOException {
        startServer(5000);
        receiveMessages();
    }

    public static void startServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server is running on port: " + port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public static void receiveMessages() throws IOException {
        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received: " + message);
            if (message.equals("exit")) {
                break;
            }
        }
    }

    public static void sendMessage(String message) throws IOException {
        out.println(message);
    }

    public static void closeConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

}