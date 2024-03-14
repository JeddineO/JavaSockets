package Number;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class Server {

    public static void main(String[] args) throws Exception
    {
        String ipAddress = "localhost";
        int port = 6666,res=1;

        ServerSocket serverSocket= new ServerSocket(port);
        //ServerSocket serverSocket=new ServerSocket(1214);
        System.out.println("Je suis le serveur j'attend une connexion");
        Socket socket=serverSocket.accept();


        InputStream inputStream=socket.getInputStream();
        OutputStream outputStream=socket.getOutputStream();

        System.out.println("J'attend la requete du client");
        int nb=inputStream.read();
        System.out.println("Je lis le nombre envoyé : "+nb);
        for (int i=1;i<=nb;i++)
            res *= i;
        System.out.println("J'ai envoyé le réponse : "+res);
        outputStream.write(res);
        socket.close();



    }
}
