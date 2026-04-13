import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25261_SocketServer_A01 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                OutputStream outputStream = socket.getOutputStream();
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String message = input.readLine();
                System.out.println("Received message: " + message);

                outputStream.write("Hello client, you are connected to the server!!".getBytes());
                outputStream.newLine();
                outputStream.flush();

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}