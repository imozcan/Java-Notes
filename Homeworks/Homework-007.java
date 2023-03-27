/*----------------------------------------------------------------------------------------------------------------------
							Onur Özcan - 0534 566 48 96 - onurozcan@protonmail.com
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------
Homework-007-01

 1. Bir tombala torbasında 1'den 99'a kadar numaralanmış (99 dahil) pullar bulunmaktadır. Bu tombala torbasıyla aşağıdaki 
 oyunlar oynanmaktadır Çekilen bir pul torbaya geri atılmamak üzere,

i) Torbadan 3 pul çekiliyor. Çekilen pulların toplamı 150' den küçük ise oyuncu kazanıyor.

ii) Torbadan 3 pul çekiliyor. Çekilen pulların toplamı asal sayı ise oyuncu kazanıyor.

iii) Torbadan 3 pul çekiliyor. En büyük değerli pul ile en küçük değerli pul arasındaki fark ortanca değerli puldan 
büyükse oyuncu kazanıyor.

Oynanacak her bir oyun için oyuncunun kazanma olasılığını en az 30000 oyunu simule ederek hesaplayınız.
----------------------------------------------------------------------------------------------------------------------*/

package csd;

class App {
	public static void main(String [] args)
	{
		BingoTestSimulation.simulation();
	}
}

class BingoTestSimulation {
	public static void simulation()
	{
		int SimulationCycle = 3000000;
		java.util.Scanner kb = new java.util.Scanner(System.in);

		System.out.printf( "Torbada 0-99 arasında pullar bulunmaktadır.%n");
		System.out.printf( "Oyunun her modunda, torbadan 3 pul çekiliyor ve çekilen pul torbaya geri atılmıyor.,%n%n");
		System.out.printf( "i)Çekilen pulların toplamı 150' den küçük ise oyuncu kazanıyor.%n");
		System.out.printf( "ii)Çekilen pulların toplamı asal sayı ise oyuncu kazanıyor.%n");
		System.out.printf( "iii)En büyük pul ile en küçük pul arasındaki fark, ortanca puldan büyükse oyuncu kazanıyor.%n%n");

		while(true) {

			System.out.printf(" 1.Mod = 1%n 2.Mod = 2%n 3.Mod = 3%n Çıkış = 4%nLütfen oyun modunu seçin: ");
			int mode = kb.nextInt();

			if (mode >= 4)
				break;

			BingoApp bingoRef = new BingoApp();

			for (int i = 0; i < SimulationCycle; i++)
				bingoRef.run(mode,bingoRef);

			bingoRef.wincal(SimulationCycle);
			System.out.printf("%d.modda oyun %d kere simule edildi. Kazanma oranı: %f%n%n",mode ,SimulationCycle, bingoRef.winRate);
		}
	}
}

class BingoApp {
	public int stamp1, stamp2, stamp3, count;
	public static boolean flag;
	public double winRate;

	public void run(int mode, BingoApp bingoRef)
	{
		StampCalculate StampValCalculaterRef = new StampCalculate();
		java.util.Random r = new java.util.Random();

		EXIT_LOOP:
		while (true) {
			stamp1 = r.nextInt(1, 100);
			stamp2 = r.nextInt(1, 100);
			stamp3 = r.nextInt(1, 100);

			if (stamp1 != stamp2 && stamp1 != stamp3 && stamp2 != stamp3)
				break EXIT_LOOP;
		}

		StampValCalculaterRef.calculater(bingoRef);

		switch (mode) {
			case 1 -> flag = StampValCalculaterRef.SumStamp < 150 ? !flag : flag;
			case 2 -> flag = NumberUtil.isPrime(StampValCalculaterRef.SumStamp);
			case 3 -> flag = StampValCalculaterRef.MaxMinDifNum > StampValCalculaterRef.MedianStamp ? !flag : flag;
		}

		if (flag)
			count++;
	}

	public void wincal(int SimulationCycle)
	{
		winRate = count / (double)SimulationCycle;
	}
}

class StampCalculate {
	public int SumStamp, MedianStamp, MaxMinDifNum;
	public static int MaxStamp, MinStamp;

	public void calculater(BingoApp bingoRef)
	{
		MaxStamp = Math.max(Math.max(bingoRef.stamp1, bingoRef.stamp2),bingoRef.stamp3);
		MinStamp = Math.min(Math.min(bingoRef.stamp1, bingoRef.stamp2),bingoRef.stamp3);

		SumStamp = bingoRef.stamp1 + bingoRef.stamp2 + bingoRef.stamp3;
		MedianStamp = SumStamp - MaxStamp - MinStamp;
		MaxMinDifNum = MaxStamp - MinStamp;
	}
}

class NumberUtil {
	public static boolean isPrime(long a)
	{
		if (a <= 1)
			return false;

		if (a % 2 == 0)
			return a == 2;

		if (a % 3 == 0)
			return a == 3;

		if (a % 5 == 0)
			return a == 5;

		if (a % 7 == 0)
			return a == 7;

		for (long i = 11; i * i <= a; i += 2)
			if (a % i == 0)
				return false;

		return true;
	}
}
/*----------------------------------------------------------------------------------------------------------------------

Homework-007-02

2. Çağrıldığında ekrana 01.01.1900 ve 31.12.2100 tarihleri arasında rasgele bir tarihi yazan printRandomDate
isimli metodu yazınız. Metodun ekrana yazdırdığı tarih geçerli bir tarih olmalıdır. Rasgele tarihin Şubat ayına
denk gelmesi durumunda, seçilen yılın artık yıl olup olmamasına göre, Şubat ayı 29 çekebilecektir. Tarih ekrana
aşağıdaki formatta yazdırılacaktır:
11th Jul 1983
-----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args)
	{
		RandomDate.printRandomDate();
	}
}


class RandomDate {
	public static int year, month, day;
	public static boolean flag;

	public static void printRandomDate()
	{
		java.util.Random r = new java.util.Random();
		year = r.nextInt(1900, 2101);
		month = r.nextInt(1, 13);
		day = r.nextInt(1, 31);


		while (true) {
			flag = DateUtil.isValidDate(day, month, year);
			if(flag)
				break;
		}


		System.out.printf("%02d",day);
		switch (day) {
			case 1 -> System.out.printf("st");
			case 2 -> System.out.printf("nd");
			case 3 -> System.out.printf("rd");
			default -> System.out.printf("th");
		}

		switch (month) {
			case 1 -> System.out.printf(" Jan ");
			case 2 -> System.out.printf(" Feb ");
			case 3 -> System.out.printf(" Mar ");
			case 4 -> System.out.printf(" Apr ");
			case 5 -> System.out.printf(" May ");
			case 6 -> System.out.printf(" Jun ");
			case 7 -> System.out.printf(" Jul ");
			case 8 -> System.out.printf(" Aug ");
			case 9 -> System.out.printf(" Sep ");
			case 10 -> System.out.printf(" Oct ");
			case 11 -> System.out.printf(" Nov ");
			case 12 -> System.out.printf(" Dec ");
		}

		System.out.printf("%04d%n",year );
	}
}

class DateUtil {
	public static boolean isValidDate(int day, int month, int year)
	{
		return 1 <= day && day <= 31 && 1 <= month && month <= 12 && day <= getDays(month, year);
	}

	public static int getDays(int month, int year)
	{
		int days = 31;

		switch (month) {
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
			case 2:
				days = 28;
				if (isLeapYear(year))
					++days;
		}

		return days;
	}

	public static boolean isLeapYear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}