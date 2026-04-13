import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27057_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9001, 1000);
            System.out.println("Server is listening on port 9001");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String clientMessage;
                if ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Client says: " + clientMessage);
                    writer.println("Server says: " + clientMessage);
                }

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}