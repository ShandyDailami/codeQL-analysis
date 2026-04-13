import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02664_SocketServer_A08 {
    private ServerSocket serverSocket;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            OutputStream outputStream = clientSocket.getOutputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String message;
            while ((message = input.readLine()) != null) {
                System.out.println("Received message: " + message);
                outputStream.write(("Hello, client\n").getBytes());
            }

            clientSocket.close();
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
        System.out.println("Server stopped");
    }

    public static void main(String[] args) throws IOException {
        VanillaSocketServer server = new VanillaSocketServer();
        server.start(8080);
    }
}