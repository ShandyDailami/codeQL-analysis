import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37012_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4445);
            System.out.println("Server is listening on port 4445...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected!");

                // Create input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Receive the client's name and respond with a greeting
                String clientName = in.readLine();
                out.println("Hello, " + clientName + "!");

                // Close the streams
                in.close();
                out.close();

                // Close the socket
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}