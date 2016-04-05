
import java.util.Scanner;

public class Main {

	double x, y, m, phi;

	void getval() {
		Scanner in = new Scanner(System.in);
		x = in.nextInt();
		y = in.nextInt();
		m = in.nextInt();
		phi = in.nextInt();

	}

	void area() {
		double degphi = Math.toRadians(phi);

		double aCircle, atriangle;
		double val = phi / 360;
		aCircle = val * 3.14 * m * m;
		atriangle = (x * y * Math.sin(degphi)) / 2;

		double area = atriangle - aCircle;
		
		dist(area);
		System.out.print(area);
		

	}
	
	void dist(double ar)
	{
		double arval = ar; 
		double z , temp1,temp2;
		temp2 = (-(4*x*x)+(y*y)+(16*arval*arval));
		System.out.print(temp2);
		temp1 = (x*x)+(y*y)-Math.pow(temp2, 0.5);
		z = Math.pow(temp1, 0.5);
		System.out.print(z);
		
		
		}

	public static void main(String[] args) {

		Main ar = new Main();
		ar.getval();
		ar.area();
		

	}

}
