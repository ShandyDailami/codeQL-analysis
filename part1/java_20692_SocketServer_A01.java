import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20692_SocketServer_A01 {
    private static final int LOCAL_PORT = 12345; // Only connections from localhost will use this port
    private static final int ALLOWED_PORT = 12346; // Only connections from this port will use this port

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(LOCAL_PORT)) {
            System.out.println("Server is listening on port " + LOCAL_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

                if (socket.getPort() == ALLOWED_PORT) {
                    // Process the socket connection here
                    new ClientHandler(socket).start();
                } else {
                    System.out.println("Connection from unallowed IP: " + socket.getInetAddress().getHostAddress());
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_20692_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Process the socket connection here
        }
    }
}