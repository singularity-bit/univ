package tema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class exercitiul_3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	Scanner s=new Scanner(System.in);
			System.out.print("introduce un nr: ");
	int nr=s.nextInt();
	int i;
	boolean contor=false;
	if(nr==0||nr==1) {
		System.out.print(nr+" nu este nr prim");
	}else {
			for(i=1;i<=nr;i++) {
				if(nr%i==0) {
					System.out.println(i+" este divizorul lui "+nr);
					contor=true;
					}
				
			    }
			if(!contor) {
				System.out.print(nr+" este prim");
	}
		
	}
	

	}

}
