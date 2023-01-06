
import java.util.Scanner;
public class DaysOfMonth {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		short iThang, iNam;
		System.out.println("Nhap thang: ");
		iThang = keyboard.nextShort();
		System.out.println("Nhap nam: ");
		iNam = keyboard.nextShort();
		switch(iThang) {
		case 1,3,5,7,8,10,12:
			System.out.println("Thang "+ iThang +" co 31 ngay.");
			break;
		case 4,6,9,11:
			System.out.println("Thang "+ iThang +" co 30 ngay.");
			break;
		case 2:
			if (iNam % 4 == 0 || iNam % 400 == 0)
				System.out.println("Thang 2 co 29 ngay.");
			else 
				System.out.println("Thang 2 co 28 ngay.");
		}
	}
	
}

