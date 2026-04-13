import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_37105_SocketServer_A07 {
    private static ExecutorService executor = Executors.newFixedThreadPool(10);
    private static Socket accept = null;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server is running...");

        while (true) {
            accept = serverSocket.accept();
            Future<?> future = executor.submit(new ClientHandler(accept));
        }
    }

    static class ClientHandler implements Runnable {
        Socket clientSocket;

        public java_37105_SocketServer_A07(Socket socket) {
            clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String clientMessage;

                while ((clientMessage = in.readLine()) != null) {
                    if (clientMessage.equals("exit")) {
                        out.writeBytes("Exit\r\n");
                        break;
                    } else {
                        out.writeBytes("Server received: " + clientMessage + "\r\n");
                    }
                }

                out.close();
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}