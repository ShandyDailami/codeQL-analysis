import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12787_SocketServer_A01 {

    private static final String SERVER_MESSAGE = "Server is running";
    private static final String CLIENT_MESSAGE = "Client: ";
    private static final String SERVER_RESPONSE = "Server response: ";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is running...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println(CLIENT_MESSAGE + " Is this working?");

            String response = in.readLine();
            System.out.println(SERVER_RESPONSE + response);

            out.close();
            in.close();
            clientSocket.close();
        }
    }
}