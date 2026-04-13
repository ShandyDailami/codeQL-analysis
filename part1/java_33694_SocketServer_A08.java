import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33694_SocketServer_A08 {

    private static final int PORT = 4444;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                new HandleClientThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class HandleClientThread extends Thread {
        private final Socket socket;
        private final InputStream input;
        private final OutputStream output;

        HandleClientThread(Socket socket) {
            this.socket = socket;
            try {
                this.input = socket.getInputStream();
                this.output = socket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            int bytesRead;
            byte[] bytes = new byte[1024];
            while ((bytesRead = this.input.read(bytes)) != -1) {
                this.output.write(bytes, 0, bytesRead);
            }
            this.closeConnection();
        }

        private void closeConnection() {
            try {
                this.input.close();
                this.output.close();
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}