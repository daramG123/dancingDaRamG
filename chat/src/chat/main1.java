package chat;

import java.io.IOException;
import java.util.Scanner;

public class main1 {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws Throwable {
		Server1 server = new Server1();
		Client1 c = new Client1();
		System.out.println("please select executing mode");
		System.out.println("1)server");
		System.out.println("2)client");
		int num = scan.nextInt();
		
		if (num==1){
			server.server();
		}

		else if (num==2){
			c.Client();
		}
		else {
			System.out.println("�옒紐� �꽑�깮�븯�뀲�뒿�땲�떎. �떎�떆 �꽑�깮�빐二쇱꽭�슂.");
		}
		
	}

}
