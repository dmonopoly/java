/*
 Overview: In this assignment you will:
 1) Turn single-threaded code into multi-threaded code.
 2) You will notice the incorrect answer printed by test() and
     convince yourself that you understand why it happened. => clobbering (before we did synchronized)
 3) Fix it.

 Run it as is first and notice:
 1) It only prints 10 lines, one for each call to b.test(). √
 2) For each TransactionSource it only does one
     transaction via doOne() √

 Here's what you are supposed to do:
 1) Make TransactionSource a thread that runs its doOne() forever. √
 2) Fix up main to create the thread and start it (as opposed to 
 creating it and just calling doOne() like it currently does). √
 3) Run it.

 You should be able to answer the following questions:
 1) Why are the sums that test() prints out not equal to $100,000? (after you did threading)
 Background: The bad result looked like a bunch of random numbers, some of which were negative.
 Answer: Clobbering data - so transactions are being done by multiple threads at the same time.
 e.g., some subtractions were done by wrong transactions, hence the negative numbers.

 2) What does the sleep(1) in the doOne() code do?
   Tells a thread to sleep for 1 ms. So the thread goes from Active to Waiting.

 Now fix the problem and run it again.
 Do the sums now add up to $100,000? Yes, across all transactions.
 */

public class UnsynchBankTestStudent {
   public static void main(String[] args) {  
      Bank b = new Bank();
      int i;
      for (i = 1; i <= Bank.NACCOUNTS; i++){
         Thread t = new Thread(new TransactionSource(b, i));
         t.start();
         // b.test(); // remove this after threading.
	  }
   }
}

class Bank {
   public static final int INITIAL_BALANCE = 10000;
   public static final int NACCOUNTS = 10;
   private long[] accounts;
   private int ntransacts;

   public Bank() { 
      accounts = new long[NACCOUNTS];
      int i;
      for (i = 0; i < NACCOUNTS; i++)
         accounts[i] = INITIAL_BALANCE;
      ntransacts = 0;
      test();
   }

   // Solution: this whole method is a critical region.
   // We want the initial while loop to ensure we transfer money from accounts
   // that have enough money.
   // Change sleep() to wait() so we can wake up the thread with notify()
   public synchronized void transfer(int from, int to, int amount) {  
      while (accounts[from] < amount) {  // if the account doesn't have money, wait
         try {  
            // Thread.sleep(5);
            wait(5);
         } catch(InterruptedException e) {
            System.out.println("Exception: "+e.getMessage());
         }
      }
      accounts[from] -= amount;
      accounts[to] += amount;
      ntransacts++;
      if (ntransacts % 5000 == 0) test();

      notify();
         // Tell other threads that got stopped in the while loop to try again
         // since I (the running thread) am done with this critical region
         // and the account values have changed since.
   }

   // Just a method to print out transactions
   public void test() {  
      int i;
      long sum = 0;

      for (i = 0; i < NACCOUNTS; i++) sum += accounts[i];
      System.out.println("Transactions:" + ntransacts + " Sum: " + sum);
   }
}

class TransactionSource implements Runnable {
   private Bank bank;
   private int from;

   public TransactionSource(Bank b, int i) {  
      from = i - 1;
      bank = b;
   }
   
   public void doOne() {
	   int to = (int)((Bank.NACCOUNTS - 1) * Math.random());
	   if (to == from) to = (to + 1) % Bank.NACCOUNTS; // avoid collision
	   int amount = 1 + (int)(Bank.INITIAL_BALANCE * Math.random()) / 2;
	   bank.transfer(from, to, amount);

	   try { 
         Thread.sleep(1); // stops thread after transfer
                        // allows next thread - to go out of the executing state into the waiting state
                        // then ready phase, then exec...
      } catch(InterruptedException e) {}
   }

   public void run() {
      while (true)
         doOne();
   }
}

