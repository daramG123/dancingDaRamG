package chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

import org.omg.CORBA.portable.InputStream;

public class Client1 {

	public void Client() throws IOException, Throwable {
		
		Scanner scan = new Scanner(System.in);

		System.out.println("채팅방에서 사용하실 이름을 입력해주세요");
		String name = scan.nextLine();
		System.out.println(name);
		System.out.println("서버의 아이피주소를 입력해주세요");
		String serverIP = "127.0.0.1";
		// String serverIP = scan.nextLine();
		Socket socket = new Socket(serverIP, 5000);
		InputStreamReader streamreader = new InputStreamReader(socket.getInputStream());
		BufferedReader reader = new BufferedReader(streamreader);
		PrintWriter wr = new PrintWriter(socket.getOutputStream());
		 
		System.out.println("占쎄퐣甕곌쑴肉� 占쎈염野껉퀣夷뤄옙�뿯占쎈빍占쎈뼄. 占쎄퐣甕곤옙 IP : " + serverIP);
		System.out.println("占쎈염野껉퀡由븝옙肉�占쎈뮸占쎈빍占쎈뼄.");

		
		String test = null;
		while ((test = reader.readLine()) != null) {
			System.out.println(test);
		}
		
		
		
		String text;
		while((text = scan.nextLine()) != null){
			System.out.print(name + " : ");
			wr.println(name + " : " + text);
			wr.flush();
			
			if(text.equals("quit"))
				break;
		}

		reader.close();
		wr.close();
		socket.close();

	}
}
