import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.security.auth.message.AuthException;
import javax.crypto.*;
import javax.crypto.spec.*;

public class java_10694_SocketServer_A08 {

    private static ExecutorService executor = Executors.newCachedThreadPool();
    private static SecretKey secretKey;

    static class Handler implements Runnable {
        Socket socket;
        Handler(Socket socket){
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // receive the client's public key
                byte[] publicKeyBytes = in.readLine().getBytes();

                // generate the shared secret key
                secretKey = KeyGenerator.generateKey(new File("keys/secret.key"));

                // encrypt the shared secret key with the client's public key
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.ENCRYPT_MODE, KeyFactory.getKey(publicKeyBytes));
                byte[] encryptedSecretKey = cipher.doFinal(secretKey.getEncoded());

                // send the encrypted shared secret key back to the client
                out.writeBytes("Received shared secret key: " + new String(encryptedSecretKey) + "\n");

                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, AuthException {
        ServerSocket serverSocket = new ServerSocket(5000);
        while (true) {
            Socket socket = serverSocket.accept();
            executor.execute(new Handler(socket));
        }
    }
}