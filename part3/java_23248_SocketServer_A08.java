import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23248_SocketServer_A08 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client has connected!");

            // Process the request
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();

            System.out.println("Received: " + request);

            // Send a response
            OutputStream out = socket.getOutputStream();
            out.write("Hello client!".getBytes());
            out.close();
        }
    }
}