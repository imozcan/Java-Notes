/*--------------------------------------------------------------------------------------------------------------------------
							Onur Özcan - 0534 566 48 96 - onurozcan@protonmail.com
---------------------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------------------------------------------

Homework-004   (Nesne, referans ytpe... kullanılmış hali)
Soru: Klavyeden girilen int türden değerlerin, toplam sayısını, en büyüğünü, en küçüğünü ve ortalamasını hesaplayan
programı aşağıdaki açıklamalara göre yazınız.

Ödevin verildiği tarihte Referans type, nesne... konuları işlenmiş miydi? hatırlayamadım. O yüzden 2 versiyonunu da yaptım
---------------------------------------------------------------------------------------------------------------------------*/

package csd;

class App {
	public static void main(String [] args)	
	{	
		SumAppTest.run();
	}
}

class SumAppTest {
	
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		SumUtil sumUtil = new SumUtil();
		
		while (true) {
			System.out.println("Yeni bir değer girmek istiyor musunuz? [Evet için 1(bir) Hayır için 0(sıfır) değerlerinden birini giriniz]");
			int Answer = Integer.parseInt(kb.nextLine());
			
			if (Answer <= 0) {
				Print.run(sumUtil);
				break;
			}
			
			System.out.print("Bir tamsayı giriniz: ");
			int values = Integer.parseInt(kb.nextLine());
			
			if (values > 100 || values < 0) {
				System.out.println("Geçersiz Değer girdiniz...");
				continue;
			}
			
			sumUtil.calculator(values);
		
	}
	}
}	

class SumUtil {
	
	public int NumberOfEnteredValues;
	public int Max;
	public int Min;	
	public double Average;
	
	public void calculator(int values)
	{	
		if (NumberOfEnteredValues == 0) //Veri elemanının Default değeri 0 olduğu için min'e ilk sorguda gelen değeri atadım.
				Min = values;

		NumberOfEnteredValues++;
		Min = Math.min(values, Min);
		Max = Math.max(values, Max);	
		Average = (Average + values) / NumberOfEnteredValues;			
	}	
}

class Print {
	
	public static void run(SumUtil results)
		{
		if (results.NumberOfEnteredValues == 0) 
			results.Min = 0;
			
			System.out.printf("Toplam %d değer girildi %n Max = %d%n Min = %d%n Avarage = %f%n",results.NumberOfEnteredValues, results.Max, results.Min, results.Average);
		}
}

	
/*-----------------------------------------------------------------------------------------------------------------------
Homework-004   (Nesnesiz Hali)  ***Çok zorlandım :)
Soru: Klavyeden girilen int türden değerlerin, toplam sayısını, en büyüğünü, en küçüğünü ve ortalamasını hesaplayan
programı aşağıdaki açıklamalara göre yazınız.
-----------------------------------------------------------------------------------------------------------------------*/

package csd;

class App {
	public static void main(String [] args)	
	{		
		SumApp.run();
	}
}

class SumApp {
	
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		int NumberOfEnteredValues = 0, Max = 0, Min = 100, sum = 0;
		double Average = 0;
		

		while (true) {
			System.out.println("Yeni bir değer girmek istiyor musunuz? [Evet için 1(bir) Hayır için 0(sıfır) değerlerinden birini giriniz]");
			int Answer = Integer.parseInt(kb.nextLine());
			
			if (Answer <= 0) {
				
				Print.run(NumberOfEnteredValues, Max, Min, Average);
				break;
			}
			
			System.out.print("Bir tamsayı giriniz");
			int values = Integer.parseInt(kb.nextLine());
			
			if (values >= 0 && values <= 100) {
				
				
				sum += values;
				NumberOfEnteredValues++;
				
				Max = values > Max ? values : Max;
				Min = values > Min ? Min : values;
				Average = (double)sum / NumberOfEnteredValues;
				continue;
			}
			
			System.out.println("Geçersiz Değer girdiniz..");
		
	}
}	


	
class Print {	
	public static void run(int NumberOfEnteredValues, int Max, int Min, double average)
	{	
		System.out.printf("Toplam %d değer girildi %n Max = %d%n Min = %d%n Avarage = %f%n",NumberOfEnteredValues, Max, Min, average);
	}
}
}


