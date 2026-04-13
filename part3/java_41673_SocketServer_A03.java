import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class java_41673_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");

            // Start a new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_41673_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();

                byte[] bytes = new byte[1024];
                int bytesRead;

                while ((bytesRead = input.read(bytes)) != -1) {
                    output.write(bytes, 0, bytesRead);
                }

                socket.close();
                System.out.println("Connection closed...");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}