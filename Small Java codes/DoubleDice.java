package csd;

class App {
	public static void main(String [] args)	
	{		
		DiceProbabilitySimulationApp.run();
	}
}

class DiceProbabilitySimulationApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while (true) {
			System.out.print("Zarlar kaç kez atılsın:");
			int n = Integer.parseInt(kb.nextLine());
			
			if (n <= 0)
				break;
			
			TwoDiceSimulation simulation = new TwoDiceSimulation();
			
			simulation.run(n);
			System.out.printf("Zarların Çift gelme olasılığı:%f%n", simulation.p);
		}
	}
}

class TwoDiceSimulation {
	public double p;

	
	public static int calculateDiceCount(int n)
	{
		java.util.Random r = new java.util.Random();
		int count = 0;
		
		for (int i = 0; i < n; ++i) 			
			if (r.nextInt(1, 7) == r.nextInt(1, 7))
				++count;

		return count;
	}
	
	
	public void run(int n)
	{
		p = calculateDiceCount(n) / (double)n;
	}
}
