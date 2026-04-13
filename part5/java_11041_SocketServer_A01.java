import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11041_SocketServer_A01 {

    private static final int PORT = 8000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port: " + PORT);

            socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream writer = socket.getOutputStream();

            String request;
            while ((request = reader.readLine()) != null) {
                System.out.println("Received request: " + request);

                if ("close".equals(request)) {
                    writer.write("Connection closed\n".getBytes());
                    socket.close();
                    serverSocket.close();
                    break;
                }

                writer.write("Hello Client, you made it! \n".getBytes());
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) {}
            }
            if (socket != null) {
                try { socket.close(); } catch (IOException e) {}
            }
        }
    }
}