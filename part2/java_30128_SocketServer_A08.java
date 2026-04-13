import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30128_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Read from client
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientMessage = reader.readLine();
                System.out.println("Client said: " + clientMessage);

                // Send response back to client
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Thank you for connecting to the server");

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}