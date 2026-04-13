import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06162_SocketServer_A07 {
    // Server's port
    private static final int PORT = 4000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_06162_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Get input and output streams
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                OutputStream output = socket.getOutputStream();

                // Authentication process
                // Here you should replace this with real authentication logic
                String clientMessage = reader.readLine();
                if (clientMessage.equals("AuthRequest")) {
                    output.write("AuthSuccess\n".getBytes());
                    output.flush();
                } else {
                    output.write("AuthFailure\n".getBytes());
                    output.flush();
                }

                socket.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}