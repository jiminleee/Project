import java.util.Scanner;

public class TEST {
public static void main(String[] args) {
	Phone p1 = new Phone();
	p1.color="빨강";
	p1.price=100;

	
	Scanner k = new Scanner(System.in);
	int a = k.nextInt();
	int b = k.nextInt();
	
	System.out.println(a+b);
	System.out.println(a-b);
	System.out.println(a*b);
	System.out.println(a/b);

}

}








