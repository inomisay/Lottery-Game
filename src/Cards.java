import java.util.Random;

public class Cards {

    /*CARDS*/
    private static Object[] deck = {"A", 2, 3, 4, 5, 6, 7, 8, 9, 10, "J", "Q", "K"};
    private Stack sortedShuffledCards;

    public static Object[] getDeck() {
    	return deck;
    }
    
    public void setDedck(Object[] deck) {
    	Cards.deck = deck;
    }
    
    public Stack randomCards(int n) {
    	Object[] selectedCards = new Object[n];
        sortedShuffledCards = new Stack(n);

        shuffleCards(deck);

        int count = 0;
        boolean[] selected = new boolean[deck.length];
        while (count < n) { // control the uniqueness of cards
            int randIndex = generateRandomIndex(deck.length);
            if (!selected[randIndex]) {
                selected[randIndex] = true;
                Object card = deck[randIndex];
                selectedCards[count] = card;
                count++;
            }
        }

        sortCards(selectedCards);

        for (int i = 0; i < selectedCards.length; i++)
            sortedShuffledCards.push(selectedCards[i]);

        return sortedShuffledCards;
    }

    private int generateRandomIndex(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    private void shuffleCards(Object[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Object temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private void sortCards(Object[] cards) {
        int front = 0;
        int rear = cards.length - 1;
        Object[] queue = new Object[cards.length];
        System.arraycopy(cards, 0, queue, 0, cards.length);

        // descending order
        for (int i = 0; i < cards.length - 1; i++) {
            Object max = queue[front];
            int maxIndex = front;
            for (int j = front + 1; j <= rear; j++) {
                if (cardValue(queue[j]) > cardValue(max)) {
                    max = queue[j];
                    maxIndex = j;
                }
            }
            for (int j = maxIndex; j < rear; j++) {
                queue[j] = queue[j + 1];
            }
            queue[rear] = max;
            rear = (rear - 1 + queue.length) % queue.length;
        }

        // changing to ascending order
        for (int i = 0; i < cards.length / 2; i++) {
            Object temp = queue[i];
            queue[i] = queue[cards.length - i - 1];
            queue[cards.length - i - 1] = temp;
        }

        System.arraycopy(queue, 0, cards, 0, cards.length);
    }

    private int cardValue(Object card) {
        if (card instanceof String) {
            switch ((String) card) {
                case "A":
                    return 1;
                case "J":
                    return 11;
                case "Q":
                    return 12;
                case "K":
                    return 13;
            }
        }
        return (int) card;
    }
    
    public void sortStack(Stack stack) {
        Stack tempStack = new Stack(100);
        while (!stack.isEmpty()) {
            // Pop the top element from the original stack
            Object curr = stack.pop();
            
            // Move all elements greater than curr from the temp stack back to the original stack
            while (!tempStack.isEmpty() && cardValue(tempStack.peek()) > cardValue(curr)) {
                stack.push(tempStack.pop());
            }
            
            // Push curr onto the temp stack
            tempStack.push(curr);
        }
        
        // Move all elements from the temp stack back to the original stack to get the sorted order
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    /*Balls*/
    public void sortCircularQueue(CircularQueue queue) {
        int n = queue.size();

        // Dequeue all elements and store in array
        Object[] arr = new Object[n];
        for (int i = 0; i < n; i++) {
            arr[i] = queue.dequeue();
        }

        // Sort array using selection sort
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (compareCards(arr[j], arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Object temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        // Enqueue sorted array back into circular queue
        int i = 0;
        while (!queue.isFull() && i < n) { // check that i is within valid range
            queue.enqueue(arr[i]);
            i++;
        }
    }
    
    private int compareCards(Object card1, Object card2) {
        int value1 = cardValue(card1);
        int value2 = cardValue(card2);
        if (value1 == -1 && value2 == -1) {
            return 0;
        } else if (value1 == -1) {
            return -1;
        } else if (value2 == -1) {
            return 1;
        } else if (value1 < value2) {
            return -1;
        } else if (value1 > value2) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public Object selectAndRemoveRandomElement(CircularQueue bag1, CircularQueue bag2) {
        if (bag1.isEmpty()) {
            return null; // nothing to dequeue
        }
        
        int size = bag1.size();
        int randIndex = (int) (Math.random() * size);

        Object removedElement = null;
        for (int i = 0; i < size; i++) {
            Object element = bag1.dequeue();
            if (i == randIndex) {
                removedElement = element; // Save the removed element
                break; // Break the loop after the element is found
            }
            else {
                bag1.enqueue(element); // Enqueue other elements back to bag1
            }
        }
        bag2.enqueue(removedElement); // Enqueue the removed element to bag2
        return removedElement; // Return the removed element
    }
    
    public void showValue(CircularQueue Q3, CircularQueue Q4, int x) {
        if (Q3.isEmpty()) {
            System.out.println("");
            return;
        }
        // Select a random element from Bag 1 and enqueue it to Bag 2
        int randIndex = (int) (Math.random() * Q3.size()); // generate a random index between 0 and size-1
        Object selectedElement = null;
        for (int i = 0; i < randIndex; i++) {
            selectedElement = Q3.dequeue(); // remove and retrieve the selected element
            Q3.enqueue(selectedElement); // enqueue the element back to Bag 1
        }
        selectedElement = Q3.dequeue(); // remove the selected element from Bag 1
        Q4.enqueue(selectedElement); // enqueue the selected element to Bag 2
        System.out.println("");
        System.out.println(x + ". Selected Value: " + selectedElement); // print the selected element
        System.out.println("");
    }

    /*HighScore Sort*/
    public void highscoreSort(CircularQueue names, CircularQueue scores) {
	    int size = scores.size();

	    // Create arrays to store names and scores
	    String[] nameArray = new String[size];
	    int[] scoreArray = new int[size];

	    // Dequeue the names and scores into the arrays
	    for (int i = 0; i < size; i++) {
	        nameArray[i] = (String) names.dequeue();
	        scoreArray[i] = (int) scores.dequeue();
	    }

	    // Sort the arrays in descending order based on the scores
	    for (int i = 0; i < size - 1; i++) {
	        for (int j = i + 1; j < size; j++) {
	            if (scoreArray[i] < scoreArray[j]) {
	                // Swap the scores
	                int tempScore = scoreArray[i];
	                scoreArray[i] = scoreArray[j];
	                scoreArray[j] = tempScore;

	                // Swap the names to keep them in sync with the scores
	                String tempName = nameArray[i];
	                nameArray[i] = nameArray[j];
	                nameArray[j] = tempName;
	            }
	        }
	    }

	    // Enqueue the sorted names and scores back into the queues
	    for (int i = 0; i < size; i++) {
	        names.enqueue(nameArray[i]);
	        scores.enqueue(scoreArray[i]);
	    }
	}
    
}