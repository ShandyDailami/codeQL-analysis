import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_09192_SocketServer_A08 {
    private static final int PORT = 9000;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(5);
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            executor.execute(new ClientHandler(socket));
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_09192_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

                byte[] buffer = new byte[1024];
                int length = dataInputStream.read(buffer);
                if (length == 0) {
                    throw new IllegalStateException("Unexpectedly reached EOF");
                }

                String request = new String(buffer, 0, length);
                System.out.println("Received request: " + request);

                dataOutputStream.writeUTF("ACK");
                dataOutputStream.flush();

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}