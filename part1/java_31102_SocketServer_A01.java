import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31102_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Error while accepting client connection");
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_31102_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Implement secure communication logic here
        // For now, we'll just echo back all incoming messages
        try (socket;
             java.io.OutputStream out = socket.getOutputStream();
             java.io.InputStream in = socket.getInputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error while handling client connection");
            e.printStackTrace();
        }
    }
}