/*--------------------------------------------------------------------------------------------------------------------------
							Onur Özcan - 0534 566 48 96 - onurozcan@protonmail.com
---------------------------------------------------------------------------------------------------------------------------*/

/*--------------------------------------------------------------------------------------------------------------------------
Homework-005-01

Bir Java programı yazarak e sayısını yukarıdaki seri toplamıyla hesaplayıp ekrana yazdırınız.
---------------------------------------------------------------------------------------------------------------------------*/

package csd;

class App {
	public static void main(String [] args)	
	{	
		AppTest.testCode();			
	}
}

class AppTest {
	public static void testCode() 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);

		while (true) {
			System.out.println("e değeri için bir sayı giriniz:  [Çımmak için 0 giriniz]");
			int val = Integer.parseInt(kb.nextLine());
			
			if (val == 0)
				break;
				
			System.out.printf("%d değeri için e = %f%n", val, MathUtil.calculate(val));
		}
	}
}

class MathUtil {
	public static double calculate(int n) 
	{ 
		double  result = 0;

		for (int i = 0; i <= n; ++i) 	
			result += (double)1 / FactorialUtil.factorial(i); // 1.0
		
		return result;	
	}
}
class FactorialUtil {
	public static int factorial(int n)
	{
		int result = 1;
		
		for (int i = 2; i <= n; ++i)
			result *= i;
		
		return result;
	}
}

/*--------------------------------------------------------------------------------------------------------------------------------------------
Homework-005-02

Parametresi ile aldığı pozitif bir tamsayının kendisi hariç tüm çarpanlarının toplamı ile geri dönen sumFactors
metodunu yazınız. Metot parametresi ile aldığı sayı hariç tüm çarpanlarının toplamına geri dönecektir: (1 her
sayının doğal çarpanıdır ve toplama dahil edilecektir.)
----------------------------------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args)	
	{	
		AppTest.testCode();			
	}
}

class AppTest {
	public static void testCode() 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Bir sayı giriniz:");
			int val = Integer.parseInt(kb.nextLine());	
		
			if (val <=0)
				break;
		
			System.out.printf("%d değeri için kendisi hariç çarpanların toplamı : %d%n",val ,MathUtil.sumFactors(val));
		}
	}	
}

class MathUtil {
	public static int sumFactors(int n) 
	{ 
		int result = 0;
		
		for (int i = 2; i < n; i++)
			if (n % i == 0) 
				result += i;	
		
		return result + 1; //Doğal çarpanı ekledik
	}
		
}
/*--------------------------------------------------------------------------------------------------------------------------------------------
Homework-005-003 

x ve y pozitif tamsayılar olmak üzere eğer x sayısının kendisi hariç bölenleri toplamı y sayısına ve aynı
zamanda y sayısının kendisi hariç bölenleri toplamı x sayısına eşit ise bu sayılar arkadaştır denir. Örneğin 220
ve 284 sayıları arkadaş sayılardır. Parametresi ile aldığı iki tamsayının arkadaş olup olmadıklarını test eden
areFriends metodunu yazınız. Metodunuzu dört basamaklı bir arkadaş sayı çifti bulan bir kodla test
edebilirsiniz.
----------------------------------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args)	
	{	
		AppTest.testCode();			
	}
}

class AppTest {
	public static void testCode() //17296 ve 18416 arkadaş sayılardır
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("iki sayı giriniz:");
			int x = kb.nextInt();	
			int y = kb.nextInt();
		
			Root.areFriends(x, y);
			if (x <=0)
				break;		
		}
	}	
}


class Root {
	public static void areFriends(int x, int y)
	{
		if (MathUtil.sumFactors(x) == y  && MathUtil.sumFactors(y) == x)
			System.out.printf("%d ve %d arkadaş sayılardır.%n",x ,y);
		else
			System.out.printf("%d ve %d arkadaş sayı değildir.%n",x ,y);
		
	}
}

class MathUtil {
	public static int sumFactors(int n) 
	{ 
		int result = 0;
		
		for (int i = 2; i < n; i++)
			if (n % i == 0) 
				result += i;	
		
		return result + 1; //Doğal çarpanı ekledik
	}
		
}


/*--------------------------------------------------------------------------------------------------------------------------------------------
Homework-005-004

4. Kendisi haricindeki tüm pozitif bölenlerinin toplamına eşit olan tamsayılara "mükemmel sayı (perfect
number)” denir. Örneğin 6 ve 28 sayıları mükemmel sayılardır:
----------------------------------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args)	
	{	
		AppTest.testCode();			
	}
}

class AppTest {
	public static void testCode() //17296 ve 18416 arkadaş sayılardır
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("bir sayı giriniz:");
			int x = Integer.parseInt(kb.nextLine());
		

			Root.perfectNumber(x);
			if (x <=0)
				break;		
		}
	}	
}

class Root {
	public static void perfectNumber(int x)
	{

		if (MathUtil.sumFactors(x) == x && x > 1)
			System.out.printf("%d mükemmel sayıdır. %n",x);
		else
			System.out.printf("%d mükemmel sayı değildir. %n",x);
		
	}
}

class MathUtil {
	public static int sumFactors(int n) 
	{ 
		int result = 0;
		
		for (int i = 2; i < n; i++)
			if (n % i == 0) 
				result += i;	
		
		return result + 1; //Doğal çarpanı ekledik
	}		
}

