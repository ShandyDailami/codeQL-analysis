import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_29926_SocketServer_A01 {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            executorService.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {
        Socket socket;

        public java_29926_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

                String message = dataInputStream.readUTF();
                System.out.println("Client says: " + message);
                if (message.equals("BREAK")) {
                    dataOutputStream.writeUTF("ACK");
                    dataOutputStream.flush();
                    socket.close();
                } else {
                    dataOutputStream.writeUTF("NACK");
                    dataOutputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}