/*----------------------------------------------------------------------------------------------------------------------
						Onur Özcan - 0534 566 4896 - onurozcan@protonmail.com
----------------------------------------------------------------------------------------------------------------------*/

/*-----------------------------------------------------------------------------------------------------------------
1.Klavyeden alınan int türden üç sayı arasındaki büyüklük-küçüklük ilişkisini küçükten büyüğe doğru < ve =
sembolleriyle gösteren programı yazınız:

Açıklama:
- Program içerisinde dizi kullanılmayacaktır. Zaten gerek de yoktur.
- Bir sıralama algoritmasına ihtiyacınız yoktur.
- Program üç tane int türden sayı isteyecektir, aralarındaki ilişkiyi ekranda gösterecektir. İşte birkaç örnek

	Giriş: 10 20 30			Yanıt: 10 < 20 < 30
	Giriş: 30 10 20			Yanıt: 10 < 20 < 30
	Giriş: 10 10 15			Yanıt: 10 = 10 < 15
	Giriş: 40 50 50			Yanıt: 40 < 50 = 50
-----------------------------------------------------------------------------------------------------------------*/

package csd;

class App {
	public static void main(String [] args)	
	{		
		TakeNumber.run();
	}
}

class TakeNumber {
	public static void run()
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("üç sayı giriniz:");
		int a = kb.nextInt();		
		int b = kb.nextInt();
		int c = kb.nextInt();	
		
		MathUtil.sizeRelations(a, b, c);
	}	
}

class MathUtil {
	public static void sizeRelations(int a, int b, int c)
	{	
		int maxNumber = Math.max(Math.max(a, b), c);
		int minNumber = Math.min(Math.min(a, b), c);
		int midNumber = a + b + c - maxNumber - minNumber;
		
		if (maxNumber == minNumber)
			System.out.printf("%d = %d = %d", a, b, c);
		else if (midNumber == maxNumber)
			System.out.printf("%d < %d = %d", minNumber, midNumber, maxNumber);
		else if (midNumber == minNumber)
			System.out.printf("%d = %d < %d", minNumber, midNumber, maxNumber);
		else
			System.out.printf("%d < %d < %d", minNumber, midNumber, maxNumber);	
	}	
}


/*-----------------------------------------------------------------------------------------------------------------
2. Parametresi ile aldığı int türden 3 sayıdan ortancasına geri dönen mid isimli metodu NumberUtil isimli sınıf
içerisinde yazınız ve test ediniz. Metot sayıların aynı olması durumunda da ortanca değere geri dönecektir.
Örneğin sayılar 10, 10, 20 ise ortanca değer 10 olacaktır.
Açıklama: Üç tane sayının ortancası sayıların toplamından sayıların en küçüğünün ve en büyüğünün toplamını
çıkartmakla bulunabilir. Metot bu şekilde yazılmayacaktır. Yani metot içerisinde sayıların en büyüğünün ve en
küçüğünün bulunmasına gerek yoktur.
-----------------------------------------------------------------------------------------------------------------*/

package csd;

class App {
	public static void main(String [] args)	
	{	
		int a = 10, b = 20, c = 30;
		
		System.out.print(NumberUtil.mid(a, b, c));
		System.out.print(NumberUtilConditionOperators.mid(a, b, c));	 //Koşul operatörü ile yazılmış hali	
	}
}

class NumberUtil {
	public static int mid(int a, int b, int c)
	{	
		int midNumber;  
			
		if (a >= b)
			if(a >= c)
				if (b >= c)
					midNumber = b;
				else
					midNumber = c;
			else
				midNumber = a;				
		else
			if (b >= c)
				if (a >= c)
					midNumber = a;
				else 
					midNumber = c;
			else
				midNumber = b;

	
					
		return midNumber;
	}	
}

class NumberUtilConditionOperators {
	public static int mid(int a, int b, int c)
	{	
			return  a > b ? (b > c ? b : (a > c ? c : a ))  :  (a > c ? a : (b > c ? b:c));	//condition operator	
	}	
}

/*-----------------------------------------------------------------------------------------------------------------
3. Parametresi ile aldığı int türden bir sayının negatif mi, 0(sıfır) mı, pozitif mi olduğunu test eden signum isimli
metodu yazınız ve test ediniz. Metot pozitif için 1(bir), negatif için -1(eksi bir) ve sıfır için 0(sıfır) döndürecektir.
Açıklama: Math sınıfının signum metodu kullanılmayacaktır.
------------------------------------------------------------------------------------------------------------------*/

package csd;

class App {
	public static void main(String [] args)	
	{	
		int a = 10;
		
		System.out.print(signum(a));
	}
	
	public static int signum(int a)
	{
		int signumNumber = a;
		
		if (a > 0)
			signumNumber = a - a + 1;		
		else if (a < 0)
			signumNumber = a - a -1;
		
		return signumNumber;	
	}	
}


