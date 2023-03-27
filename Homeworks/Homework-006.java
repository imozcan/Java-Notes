/*----------------------------------------------------------------------------------------------------------------------
							Onur Özcan - 0534 566 48 96 - onurozcan@protonmail.com
----------------------------------------------------------------------------------------------------------------------*/

/*---------------------------------------------------------------------------------------------------------------------- 
Homework-006	Soru: Craps Oyununu 100000 kere simüle eden programı yazınız.  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args)
	{
		CrapsTestSimulation.simulation();
	}
}

class CrapsTestSimulation {
	public static void simulation()
	{

		System.out.printf("Craps iki zar ile oynanan bir oyundur ve oyunun kuralları şu şekildedir%n");
		System.out.printf("i) Atılan iki zarın toplam değeri 7 ya da 11 ise oyuncu kazanır.%n");
		System.out.printf("ii) 2, 3, 12 ise oyuncu kaybeder. (Buna craps denir!)%n");
		System.out.printf("iii) İki zarın toplam değeri yukarıdakilerin dışında bir değer ise, zar atmaya devam eder. %n");
		System.out.printf("Eğer ilk attığı zarların toplamını tekrar atabilirse kazanır. %n");
		System.out.printf("ilk attığı sayıyı atmadan önce 7 atarsa oyunu kaybeder. %n%n%n");

		int SimulationCycle = 100000;

		CrapsApp Simulation = new CrapsApp();

		for (int i = 0; i < SimulationCycle; i++)
			Simulation.run(Simulation);

		Simulation.wincal(SimulationCycle);
		System.out.printf("Oyun %d kere simule edildi. Kazanma oranı: %f%n%n" ,SimulationCycle, Simulation.winRate);
	}
}

class CrapsApp {
	public static int count;
	public int dice, dice1, sumDices;
	public double winRate;

	public void run(CrapsApp Simulation)
	{
		java.util.Random r = new java.util.Random();
		dice = r.nextInt(1, 7);
		dice1 = r.nextInt(1, 7);

		sumDices = dice + dice1;

		if (sumDices == 7 || sumDices == 11)
			count++; //Win

		else if (sumDices == 2 || sumDices == 3 || sumDices == 12)
			;//Loss

		else
			while (true) {
				int newDice = r.nextInt(1, 7);
				int newDice1 = r.nextInt(1, 7);

				if (newDice + newDice1 == 7)
					break; //Loss

				if (newDice + newDice1 == sumDices) {
					count++; //Win
					break;
				}
			}

		public void wincal(int SimulationCycle)
		{
			winRate = count / (double)SimulationCycle;
		}
	}
