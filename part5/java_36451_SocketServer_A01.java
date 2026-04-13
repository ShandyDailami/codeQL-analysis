import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36451_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client " + clientSocket.getInetAddress().getHostAddress() + " connected.");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String command;
                while ((command = in.readLine()) != null) {
                    System.out.println("Received command: " + command);

                    if ("QUIT".equals(command)) {
                        out.println("Server is closing the connection.");
                        clientSocket.close();
                        break;
                    }

                    out.println("Server received your message: " + command);
                }

                out.close();
                clientSocket.close();
                System.out.println("Client " + clientSocket.getInetAddress().getHostAddress() + " disconnected.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}