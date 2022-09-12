import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class NetBenefit{
	static IntQueueImpl queue = new IntQueueImpl(); //Queue Creation
	static String path = null; //Path of file
	
	public static void main(String[] args){
		path = args[0];//path is given by user using cmd command
		
		readFile();
	}
	
	public static void readFile(){
		File f = null;
		BufferedReader reader = null;
		
		String line;
		
		try{ //creates a new File
			f = new File(path);
		} catch (NullPointerException e) {
			System.err.println("File not found!");
		}
		
		try{ //creates a new BufferedReader
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		} catch (FileNotFoundException e) {
			System.err.println("Error opening file!");
		}
		
		try{
			line = reader.readLine();

			boolean available = true; //checks if there is enough available quantity to be sold 
			boolean emptyFile = true; //checks if the file is empty
			
			int sells = 0; // keeps how much money we earned from selling 
			int buys = 0; // keeps how much money we spent for the items that we sold
			int result = 0; //final result 
			
			while(line!=null){//until the file ends
				sells = 0;
				buys = 0;
				line = line.replaceAll("\\s", ""); //replaces spaces with nothing
				
				if(line != null && !line.isEmpty()){
					if(emptyFile)emptyFile = false;//indicates that file is not empty (happens only once)
					
					if(line.substring(0, 3).equalsIgnoreCase("buy")){ //if text starts with buy
						int quantityBuy = 0;
						int price = 0;
						
						line = line.substring(3);//moves line 3 letters to the right (moves past buy)
						
						int i = 0;
						
						while(line.charAt(i) != 'p' && line.charAt(i) != 'P'){//marks the numbers amount of digits 
							i++;
						}
						
						quantityBuy = Integer.parseInt(line.substring(0,i));//parse string numbers into integer numbers 
						
						price = Integer.parseInt(line.substring(i+5));//does the same with price's numbers
						
						queue.put(quantityBuy);//quantity and price are added to the queue in integer format
						queue.put(price);
						
					}
					else if(line.substring(0, 4).equalsIgnoreCase("sell")){	//if text starts with sell
						int quantitySell = 0;
						int price = 0;
						
						line = line.substring(4);//moves 4 places to the right
						
						int i = 0;
						
						while(line.charAt(i) != 'p' && line.charAt(i) != 'P'){//the same process is repeated to collect the numbers's and price's digits
							i++;
						}
						
						quantitySell = Integer.parseInt(line.substring(0,i));
						
						price = Integer.parseInt(line.substring(i+5));
						
						sells = quantitySell * price;
						
						while(quantitySell!=0){//if there are selling requests
							if(queue.size()>2){//if there are at least two pairs of quantity and price in the queue
								if(queue.peek()<=quantitySell){ //if it tries to sell exactly the amount of the oldest item on the queue or more
									quantitySell = quantitySell - queue.peek();
									buys = buys + (queue.get() * queue.get());	
								}
								else{ //if the oldest item is > of the quantity we want to sell
									buys = buys + (quantitySell * (int) queue.first.getNext().getElement());
									queue.first.element = (int)queue.first.getElement() - quantitySell;
									quantitySell = 0;
								}
							}
							else{//if there is only one pair remaining
								if(queue.peek()<quantitySell){ //if it tries to sell more than available on the oldest item on queue
									available = false;
									break;
								}
								else if(queue.peek()==quantitySell){ //if it tries to sell exactly the amount of the oldest item on the queue 
									quantitySell = quantitySell - queue.peek();
									buys = buys + (queue.get() * queue.get());	
								}
								else{ //if tries to sell less than the amount of the oldest item on the queue 
									buys = buys + (quantitySell * (int) queue.first.getNext().getElement());
									queue.first.element = (int)queue.first.getElement() - quantitySell;
									quantitySell = 0;
								}
							}
						} //while end
						
						result = result + (sells - buys); //final result for 
						
						if(!available){ //requested amount exceeds the available amount
							System.out.println("Error with file!");
							break;
						}
					} //else if
				}
					
				line = reader.readLine();
			} //while end
			
			if(!emptyFile){ //if file is not empty
				if(available){ //if it didn't try to sell more items that there are available somewhere
					if(result>=0){
						System.out.println("Profit: " + result);
					}
					else{
						result = result * (-1);
						System.out.println("Loss: " + result);
					}
				}
			}else{
				System.out.println("The file is empty.");
			}
		} //try
		catch (IOException e) {
			System.out.println("Error reading file!");
		}
	}
}