class Math
{
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		//test sqrt methods

		sqrt(4070);
		bisectSqrt(4070);
		newtonSqrt(4070);

		System.out.println(System.currentTimeMillis() - startTime + "ms");

	}

//======================================================================

	public static void sqrt(double x) {

			double count = 1.0;
			double error = 1e-3;

			while(count*count < x) count++;

			if(x%count==0) System.out.println("Root of " + x + " is " + count + ". Perfect square.");

			else
			{
				System.out.println("Not perfect square. Calculating decimals.");

				count--;

				while(count*count < x) { count += error; print(count); }

				System.out.println("Root of " + x + " is " + count + ".");
			}
		}

//======================================================================

	public static void bisectSqrt(double x){

		double low = 0;
		double high = x;
		double guess = (low+high)/2.0;
		boolean rootfound = false;
		double error = 1e-12;

		while(rootfound == false)
			{
				if(guess*guess > x+error) high = guess;
				else if(guess*guess < x-error) low = guess;
				else rootfound = true;
				guess = (low+high)/2.0;
				print(guess);

				//System.out.print("\nlow " + low + " high " + high + " guess " + guess); //test
			}
	}

//======================================================================

	public static void newtonSqrt(double x){

		double guess = x;
		double error = 1e-12;

		while(guess*guess > x+error || guess*guess < x-error)
			{
				guess -= (guess*guess - x)/(2*guess);
				print(guess);
			}
	}

//======================================================================

	public static void print(double x){System.out.println(x);}
}
