import java.util.Scanner;

public class Test2 {
public static void main(String[] args) {
	
	Scanner k = new Scanner(System.in);
	int no2 = k.nextInt();
	
	for (int i = 1; i <no2; i++) {
		if (i % 2==1) {
			System.out.println(i);
		}
	}
}
}
