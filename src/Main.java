import com.sun.source.tree.Tree;

import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * Total Marks Main Class: 25
 * Compilation & Correct Execution Marks: 10
 */
public class Main {
	static LinkedQueue<Transaction> buyQueue = new LinkedQueue<Transaction>();
	static LinkedQueue<Transaction> sellQueue = new LinkedQueue<Transaction>();
	static int totalGain = 0;
	
	/**
	 * Process queue of transactions - determine if each transaction is a buy or sell
	 * transaction & add it to the appropriate queue
	 * @param transactions - a queue of buy and sell transactions
	 * 15 marks
	 */
	public static void processTransactions(LinkedQueue<String> transactions) {
		while (!transactions.isEmpty()){
			if(transactions.first().contains("BUY")){
				// create tokenizer and pass the string without BUY literal
				StringTokenizer tokenizer = new StringTokenizer(transactions.dequeue().replace("BUY", "").trim(), " ");
				// create transaction object
				Transaction newTransaction = new Transaction(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
				buyQueue.enqueue(newTransaction); // add transaction
			} else if (transactions.first().contains("SELL")){
				// create tokenizer and pass the string without SELL literal
				StringTokenizer tokenizer = new StringTokenizer(transactions.dequeue().replace("SELL", "").trim(), " ");
				// create transaction object
				Transaction newTransaction = new Transaction(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
				sellQueue.enqueue(newTransaction); // add transaction
			}
		}
	}
	
	/**
	 * Calculate capital gain(loss)
	 * @return totalGain
	 * 10 marks
	 */
	public static Integer calculateCapitalGainLoss() {
		// get the sell transaction info
		Transaction sellTrans = sellQueue.dequeue();
		int sellQuantity = sellTrans.getQuantity();

		//COMPLETE CODE HERE
		do {
			Transaction current = buyQueue.dequeue(); // get current transaction
			if(sellQuantity <= 0) break; // stop
			if(current.getQuantity() > sellQuantity){
				// get the portion we need to continue the calculation
				int shortQuantity = Math.min(sellQuantity, current.getQuantity());
				totalGain += ((shortQuantity) * (sellTrans.getUnitPrice() - current.getUnitPrice()));
				sellQuantity -= shortQuantity; // subtract that portion from the sell quantity
			} else {
				// perform calculation
				totalGain += ((current.getQuantity()) * (sellTrans.getUnitPrice() - current.getUnitPrice()));
				// otherwise keep on subtracting the portion from the current buy transaction
				sellQuantity -= current.getQuantity(); // otherwise decrement
			}
		} while (!buyQueue.isEmpty());
		return totalGain;
	}
	
	public static void main(String[] args) {
		String response = "";
		Scanner s = new Scanner(System.in);
		LinkedQueue<String> instructionQueue = new LinkedQueue<String>();
		Integer capGainLoss;
		
		while (!response.toLowerCase().equals("quit")){
			System.out.println("Select option: ");
			System.out.println("1) Enter new transaction");
			System.out.println("2) Calculate capital gain or loss");
			System.out.println("or \"quit\" to quit.");
			response = s.nextLine();
			
			switch(response.toLowerCase()){
				case "1": {
					System.out.println("Enter transaction:");
					response = s.nextLine();
					if (!response.equals(""))
						instructionQueue.enqueue(response);
				}
					break;
				case "2": {
					processTransactions(instructionQueue);
					capGainLoss = calculateCapitalGainLoss();
					if (capGainLoss == null)
						System.out.println("Unmatched sell transaction(s).");
					else
						System.out.println("Capital Gain/Loss: "+capGainLoss);
				}
					break;
				case "quit": break;
				default: System.out.println("Incorrect option selected. Please try again.");
			}			
		}
	}
}