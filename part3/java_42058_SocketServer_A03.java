import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_42058_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8000);
        System.out.println("Server is running on port 8000...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received message from client: " + message);
                out.println("Echo: " + message);
            }

            socket.close();
        }
    }
}