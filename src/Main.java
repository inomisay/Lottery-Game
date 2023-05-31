import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		boolean flag = true;
		while(flag) {
			System.out.println("Welcome to the Lottery Game");
			System.out.println("---------------------------");
			
			/***********************************************/
			// Getting the value n from the user
			Scanner sc = new Scanner(System.in);
			int n = 0;
			// controlling the value n
			do {
				System.out.print("\nPlease give us a number (between 7 and 10): "); // card value
				
		        //Prevent string input crashing the program.
		        while (!sc.hasNextInt()) {
		            System.out.printf("\nInput doesn't match specifications. Try again.\n");
					System.out.print("\nPlease give us a number (between 7 and 10): "); // card value
		            sc.next(); 
		        }
		        //Set the number.
		        n = sc.nextInt();

		        //If the number is outside range print an error message.
		        if (n < 7 || n > 10)
		            System.out.printf("\nInput doesn't match specifications. Try again.\n");
		    } while (n < 7 || n > 10);
			
			System.out.println("\n************************************************");
			System.out.println("");
			System.out.println("Let the Game Begin");

			/***********************************************/
			// Starting the Game 
			Cards deckOfCards = new Cards();
			int gameScore1 = 0;
			int gameScore2 = 0;
			
			// Game Playing 
			System.out.println("");
			
			// Player 1
			Stack player1_Cards = new Stack(n);
			player1_Cards = deckOfCards.randomCards(n);
			Stack s1_0 = new Stack(n);
			Stack tempStack1 = new Stack(n); // temporary stack to hold elements

			while (!(player1_Cards.isEmpty())) {
			    Object card = player1_Cards.pop();
			    s1_0.push(card); // push the card to s1_0 for display
			    tempStack1.push(card); // push the card to tempStack1 to preserve the data
			}
			// Move the elements back to player1_Cards from tempStack1 in the original order
			while (!tempStack1.isEmpty()) {
			    player1_Cards.push(tempStack1.pop());
			}
			deckOfCards.sortStack(s1_0); // sort
			System.out.print("Player1: "); // Player 1 Show
			while (!(s1_0.isEmpty())) {
			    System.out.print(s1_0.pop() + " ");
			}
			
			// Score
			System.out.print("      Score: " + gameScore1);
			
			// Bag 1
			CircularQueue Q3 = new CircularQueue(13); // balls
			for (int i = 0; i < Cards.getDeck().length; i++) { // Assign the deck to the Q3
			    if (!Q3.isFull()) {
			        Q3.enqueue(Cards.getDeck()[i]);
			    }
			}
			deckOfCards.sortCircularQueue(Q3); // sort
			System.out.print("      Bag 1: "); // Bag 1 Show
			Queue Q3_Show = new Queue(Q3.size()); // Temporary queue to hold elements from Q3
			while (!Q3.isEmpty()) {
			    Object element = Q3.dequeue();
			    Q3_Show.enqueue(element); // Enqueue to Q3_Show queue for printing
			    System.out.print(element + " ");
			}
			while (!Q3_Show.isEmpty()) { // Enqueue elements back to Q3
			    Object element = Q3_Show.dequeue();
			    Q3.enqueue(element);
			}
			/*--------------------------------------------------------------------------------------------*/
			System.out.println("");
			
			// Player 2
			Stack player2_Cards = new Stack(n);
			player2_Cards = deckOfCards.randomCards(n);
			Stack s2_0 = new Stack(n);
			Stack tempStack2 = new Stack(n); // temporary stack to hold elements
			while (!(player2_Cards.isEmpty())) {
			    Object card = player2_Cards.pop();
			    s2_0.push(card); // push the card to s2_0 for display
			    tempStack2.push(card); // push the card to tempStack2 to preserve the data
			}
			// Move the elements back to player2_Cards from tempStack2 in the original order
			while (!tempStack2.isEmpty()) {
				player2_Cards.push(tempStack2.pop());
			}
			deckOfCards.sortStack(s2_0); // sort
			System.out.print("Player2: "); // Player 2 Show
			while (!(s2_0.isEmpty())) {
			    System.out.print(s2_0.pop() + " ");
			}	
			
			// Score
			System.out.print("      Score: " + gameScore2);

			// Bag 2
			CircularQueue Q4 = new CircularQueue(13); // removed balls
			Queue Q4_Show_1 = new Queue(Q4.size()); // Temporary queue to hold elements from Q4
			System.out.print("      Bag 2: "); // Bag 2 Show 
			while (!Q4.isEmpty()) {
			    Object element = Q4.dequeue();
			    Q4_Show_1.enqueue(element); // Enqueue to Q4_Show_1 queue for printing
			    System.out.print(element + " ");
			}
			while (!Q4_Show_1.isEmpty()) { // Enqueue elements back to Q4
			    Object element = Q4_Show_1.dequeue();
			    Q4.enqueue(element);
			}
			System.out.println("");
			/*--------------------------------------------------------------------------------------------*/
			// Initialize counters for each player
			int player1_counter = 0;
			int player2_counter = 0;
			
			// Player 1
			Stack s1_1 = new Stack(n);
			Stack tempStack1_1 = new Stack(n); // temporary stack to hold elements
			while (!player1_Cards.isEmpty()) {
			    Object card = player1_Cards.pop();
			    s1_1.push(card); // push the card to s1_1 for display
			    tempStack1_1.push(card); // push the card to tempStack to preserve the data
			}
			// Player 2
			Stack s2_1 = new Stack(n);
			Stack tempStack2_1 = new Stack(n); // temporary stack to hold elements

			while (!player2_Cards.isEmpty()) {
			    Object card = player2_Cards.pop();
			    s2_1.push(card); // push the card to s2_1 for display
			    tempStack2_1.push(card); // push the card to tempStack to preserve the data
			}
			
			//------------------- (Loop)
			int x = 1;
			/*--------------------------------------------------------------------------------------------*/
			while(!(s1_1.isEmpty()) || !(s2_1.isEmpty()) || !(Q3.isEmpty())) {
				
				
				Object removedCards = "";
				Object selectedCard = "";
				if (!Q3.isEmpty()) {
				    selectedCard = deckOfCards.selectAndRemoveRandomElement(Q3, Q4);
				    removedCards = Q4.dequeue();
				    Q4.enqueue(removedCards);
				    System.out.println("");
			        System.out.println(x + ". Selected Value: " + selectedCard); // print the selected element
			        System.out.println("");
				}
				else {
				    break;
				}
				
				int stackSize_1 = s1_1.size();
				Stack tempStack1_11 = new Stack(stackSize_1); // Temporary stack to hold elements

				// Check if the removed card is in player 1's cards
				// Search for the element to remove and move all other elements to a temporary stack			
				boolean removed1 = false;
				for (int i = 0; i < stackSize_1; i++) {
				    Object element = s1_1.pop();
				    if (element.equals(selectedCard)) {
				        removed1 = true;
				    } else {
				        tempStack1_11.push(element);
				    }
				}

				// Move all the elements back to the original stack
				while (!tempStack1_11.isEmpty()) {
				    s1_1.push(tempStack1_11.pop());
				}
				
				deckOfCards.sortStack(s1_1); // sort
				// Remove the selected card from s1_1
				int s1_1_size = s1_1.size();
				Stack tempStack1_2 = new Stack(s1_1_size); // Temporary stack to hold elements

				for (int i = 0; i < s1_1_size; i++) {
				    Object element = s1_1.pop();
				    if (!element.equals(removedCards)) {
				        tempStack1_2.push(element);
				    }
				}
				while (!tempStack1_2.isEmpty()) { // Move all the elements back to the original stack
				    s1_1.push(tempStack1_2.pop());
				}
				

				// Player 1 Show
				System.out.print("Player1: ");
				Stack tempStack1_3 = new Stack(s1_1_size); // Temporary stack to hold elements
				while (!s1_1.isEmpty()) {
				    Object card = s1_1.pop();
				    System.out.print(card + " ");
				    tempStack1_3.push(card); // push the card to a temporary stack to preserve the data
				}
				while (!tempStack1_3.isEmpty()) { // Move the elements back to s1_1 from tempStack1_3 in the original order	
				    s1_1.push(tempStack1_3.pop());
				}
					
				// Increment Player 1's counter if they successfully remove an element from their stack
				if (removed1) { // points
				    player1_counter++;
				    gameScore1 += 10;
				    if (player1_counter == 4) {
				        gameScore1 += 30;
				    }
				} else {
				    gameScore1 -= 5;
				}
				
				// Score
				System.out.print("      Score: " + gameScore1);
				
				// Bag 1
				deckOfCards.sortCircularQueue(Q3); // sort	
				// Bag 1 Show
				System.out.print("      Bag 1: ");
				Queue Q3_Show_1 = new Queue(Q3.size()); // Temporary queue to hold elements from Q3
				while (!Q3.isEmpty()) {
				    Object element = Q3.dequeue();
				    Q3_Show_1.enqueue(element); // Enqueue to Q3_Show_1 queue for printing
				    System.out.print(element + " ");
				}
				while (!Q3_Show_1.isEmpty()) { // Enqueue elements back to Q3
				    Object element = Q3_Show_1.dequeue();
				    Q3.enqueue(element);
				}
				/*--------------------------------------------------------------------------------------------*/
				int stackSize_2 = s2_1.size();
				Stack tempStack2_11 = new Stack(stackSize_2); // Temporary stack to hold elements

				// Search for the element to remove and move all other elements to a temporary stack
				boolean removed2 = false;
				while (!s2_1.isEmpty()) {
				    Object element = s2_1.pop();
				    if (element.equals(selectedCard)) {
				        removed2 = true;
				    } else {
				        tempStack2_11.push(element);
				    }
				}

				while (!tempStack2_11.isEmpty()) { // Move all the elements back to the original stack in reverse order
				    s2_1.push(tempStack2_11.pop());
				}

				deckOfCards.sortStack(s2_1); // sort
				
				// Remove the selected card from s2_1
				int s2_1_size = s2_1.size();
				Stack tempStack2_2 = new Stack(s2_1_size); // Temporary stack to hold elements

				for (int i = 0; i < s2_1_size; i++) {
				    Object element = s2_1.pop();
				    if (!element.equals(removedCards)) {
				        tempStack2_2.push(element);
				    }
				}
				while (!tempStack2_2.isEmpty()) { // Move all the elements back to the original stack
				    s2_1.push(tempStack2_2.pop());
				}
				
				// Player 2 Show
				System.out.println("");
				System.out.print("Player2: ");
				Stack tempStack2_3 = new Stack(s2_1_size); // Temporary stack to hold elements
				while (!s2_1.isEmpty()) {
				    Object card = s2_1.pop();
				    System.out.print(card + " ");
				    tempStack2_3.push(card); // push the card to a temporary stack to preserve the data
				}
				while (!tempStack2_3.isEmpty()) { // Move the elements back to s2_1 from tempStack2_3 in the original order
				    s2_1.push(tempStack2_3.pop());
				}
				
				// Increment Player 2's counter if they successfully remove an element from their stack
				if (removed2 == true) { // points
				    player2_counter++;
				    gameScore2 += 10;
				    if (player2_counter == 4) {
				        gameScore2 += 30;
				    }
				} else {
				    gameScore2 -= 5;
				}
				
				// Score
				System.out.print("      Score: " + gameScore2);

				// Bag 2
				Queue Q4_Show_2 = new Queue(Q4.size()); // Temporary queue to hold elements from Q4
				// Bag 2 Show
				System.out.print("      Bag 2: "); // empty at first
				while (!Q4.isEmpty()) {
				    Object element = Q4.dequeue();
				    Q4_Show_2.enqueue(element); // Enqueue to Q4_Show_2 queue for printing
				    System.out.print(element + " ");
				}
				while (!Q4_Show_2.isEmpty()) { // Enqueue elements back to Q4
				    Object element = Q4_Show_2.dequeue();
				    Q4.enqueue(element);
				}	
				System.out.println("");
				
				if(s1_1.isEmpty() && s2_1.isEmpty()) { // if they remove the last card at the same time they share the score
				    gameScore1 += 50;
				    gameScore2 += 50;
				}
				if(s1_1.isEmpty()) { // if all the cards are empty
				    gameScore1 += 50;
				}	
				if(s2_1.isEmpty()) { // if all the cards are empty
				    gameScore2 += 50;
				}
				
				if (removed1) { // points
				    player1_counter++;
				    if (player1_counter == 4) {
				        System.out.println("");
				        System.out.println("\nFirst tournament is completed! Player 1 is ahead.\n");
				    }
				}
				if (removed2 == true) { // points
				    player2_counter++;
				    if (player2_counter == 4) {
				        System.out.println("");
				        System.out.println("\nFirst tournament is completed! Player 2 is ahead.\n");
				    }
				} 
				
				x++;
			}
			/***********************************************/
			// Read from the file.txt; show the HighScore and update it write it to the file.txt
			
			// Creating two queues Q1 for names and Q2 for scores
			CircularQueue names = new CircularQueue(24);
			CircularQueue scores = new CircularQueue(24);
			        
			// Reading the unsorted file using the BufferedReader class
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader("highscoretable.txt"));
			    String line = br.readLine().trim();
			    while (line != null) {
			        // Splitting each line into name and score
			        String[] parts = line.split(" ");                 
			        if (parts.length != 2) {
			            System.out.println("Invalid file format!");
			            return;
			        }
			        names.enqueue(parts[0]); // names
			        scores.enqueue(Integer.parseInt(parts[1])); // scores
			        line = br.readLine();
			    }                            
			    br.close();
			} catch (IOException e) {
			    System.out.println("Error reading file: " + e.getMessage());
			    return;
			} catch (NumberFormatException e) {
			    System.out.println("Invalid file format: " + e.getMessage());
			    return;
			} finally {
	            if(br != null) {
	                try {
	                    br.close();
	                }
	                catch(IOException e) {
	    			    System.out.println("We encouner an Error: " + e.getMessage());
	                }
	            }
	        }

			/***********************************************/
			
			int newScore = 0;
			System.out.println("");
			if(gameScore1 < gameScore2) {
				System.out.println("Player 2 is the winner!\n Score: " + gameScore2);
				newScore = gameScore2;
				// Add the new score to the queue
				scores.enqueue(newScore);
				System.out.println("");
				System.out.print("Enter your name: ");
				String newWinner = sc.next();
				names.enqueue(newWinner);
				System.out.println("");
			}
			else if(gameScore1 > gameScore2) {
				System.out.println("Player 1 is the winner! \n Score: " + gameScore1);
				newScore = gameScore1;
				// Add the new score to the queue
				scores.enqueue(newScore);
				System.out.println("");
				System.out.print("Enter your name: ");
				String newWinner = sc.next();
				names.enqueue(newWinner);
				System.out.println("");
			}
			else if(gameScore1 == gameScore2) {
				System.out.println("Tie!");
				newScore = 0;
			}
			System.out.println("");

			// Sort the queue in descending order
			deckOfCards.highscoreSort(names, scores);
			
			// Control the size
			if (scores.size() > 12) {
			    // Dequeue all the elements and store them in a temporary queue
			    CircularQueue tempScores = new CircularQueue(scores.size());
			    CircularQueue tempNames = new CircularQueue(names.size());
			    while (scores.size() > 1) {
			        tempScores.enqueue(scores.dequeue());
			        tempNames.enqueue(names.dequeue());
			    }
			    // Discard the last element
			    scores.dequeue();
			    names.dequeue();
			    // Enqueue back the elements from the temporary queue
			    while (!tempScores.isEmpty()) {
			        scores.enqueue(tempScores.dequeue());
			        names.enqueue(tempNames.dequeue());
			    }
			}			
		
			// Display the top 12 scores with names
			System.out.println("Top 12 high scores:");
			System.out.println("-------------------");
			int count = 0;
			while (!scores.isEmpty() && count < 12) {
				String name = (String) names.dequeue();
				names.enqueue(name);
				int score = (int) scores.dequeue();
				scores.enqueue(score);
				// Sort the queue in descending order
				System.out.println(name + " " + score);
				count++;

			}
			if (scores.isEmpty()) {
			    System.out.println("There are no more scores to display.");
			}			
						    
			/***********************************************/
			// Write the updated scores to the file
			BufferedWriter bw = null;
			try {
			    bw = new BufferedWriter(new FileWriter("highscoretable.txt"));
			    while (!names.isEmpty() && !scores.isEmpty()) {
			        String name = (String) names.dequeue();
			        int score = (int) scores.dequeue();
			        bw.write(name + " " + score);
			        bw.newLine();
			    }
			    bw.close();
			} catch (IOException e) {
			    System.out.println("Error writing to file: " + e.getMessage());
			    return;
			} finally {
	            if(bw != null) {
	                try {
	                    bw.close();
	                }
	                catch(IOException e) {
	    			    System.out.println("We encouner an Error: " + e.getMessage());
	                }
	            }
			}      
	 		/***********************************************/
			System.out.println("");
	        // Asking user if he/she wants to play again
	        String question;
	        do {	            
	            System.out.print("Do you want to play again? (y/n): ");
	            //Prevent string input crashing the program.
	            while (!sc.hasNext()) {
	                System.out.println("Invalid input. Please enter 'y' or 'n'.");
		            sc.next(); 
		        }
	            question = sc.nextLine().toLowerCase();
	        	System.out.println("");

	        } while (!question.equals("y") && !question.equals("n"));
			
	        if (question.equals("y")) {
			    flag = true;
			} else if(question.equals("n")) {
			    flag = false;
			    break;
			}
		}
	}
}
