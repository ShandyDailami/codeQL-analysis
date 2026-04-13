import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07858_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server is listening on port 8000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                OutputStream outputStream = socket.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String request = reader.readLine();
                System.out.println("Received: " + request);

                // Assume the request is a login request with username and password.
                // This is a simplistic example and should not be used in a real-world application.
                String[] parts = request.split(" ");
                String username = parts[1];
                String password = parts[2];

                if ("test".equals(username) && "password".equals(password)) {
                    outputStream.write("Login successful\n".getBytes());
                    outputStream.flush();
                } else {
                    outputStream.write("Login failed\n".getBytes());
                    outputStream.flush();
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}