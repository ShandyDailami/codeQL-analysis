import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31030_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 1234; // you may change this port number
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is running on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                handleClient(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket socket) {
        new Thread(() -> {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                OutputStream writer = socket.getOutputStream();

                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received: " + request);

                    // Here you could add some security-sensitive operations related to A08_IntegrityFailure

                    // Respond to the client
                    writer.write("Hello, client!".getBytes());
                    writer.newLine();
                    writer.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}