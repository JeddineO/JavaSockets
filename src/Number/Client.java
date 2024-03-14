package Number;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception
    {
        String serverIpAddress = "localhost";
        int serverPort = 6666;

        Socket socket = new Socket(serverIpAddress, serverPort);


        System.out.println("Je suis le client");
        InputStream inputStream=socket.getInputStream();
        OutputStream outputStream=socket.getOutputStream();

        Scanner scanner=new Scanner(System.in);
        System.out.println("Entrez un nombre : ");
        int nb=scanner.nextInt();

        System.out.println("J'envoie le nombre "+nb+" au serveur");
        outputStream.write(nb);
        System.out.println("J'attend la réponse du serveur");
        int rep=inputStream.read();
        System.out.println("La réponse reçu est : "+rep);


    }
}
