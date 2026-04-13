import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31910_SocketServer_A08 {

    private static final int SERVER_PORT = 8000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Here you would typically handle the communication between the client and the server.
                // For now, we'll just close the connection after a simple echo.
                new EchoClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to setup the server socket: " + e.getMessage());
        }
    }

    private static class EchoClientHandler extends Thread {
        private final Socket clientSocket;

        public java_31910_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (Socket echoSocket = new Socket(clientSocket.getInetAddress(), SERVER_PORT)) {
                byte[] request = new byte[1024];
                int bytesRead;

                while ((bytesRead = clientSocket.getInputStream().read(request)) != -1) {
                    echoSocket.getOutputStream().write(request, 0, bytesRead);
                }
            } catch (IOException e) {
                System.err.println("Failed to handle client: " + e.getMessage());
            }
        }
    }
}