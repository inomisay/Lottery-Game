# Lottery-Game!

<img width="222" alt="Screen Shot 2023-05-31 at 16 07 58" src="https://github.com/inomisay/Lottery-Game/assets/98346164/ba6b948a-bda9-436c-93f6-4546f7102f6c">

# Lottery Game

Write a program in the Java programming language for a simple Lottery game. General Information
Two players play the game with: - cards
- bags including lottery balls
Each player selects a lottery card and tries to be the first player that matches randomly selected values with all the values on the card. Each card consists of n values, where n is ranged from 7 to 10.
The cards contain values from a suit of a deck, including A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, and K.

# Initially

Read an *unsorted* file “D:\\highscoretable.txt” and then create two **Queues (Q1 and Q2)**, which are *sorted* by score as follows:

<img width="726" alt="Screen Shot 2023-05-31 at 16 08 28" src="https://github.com/inomisay/Lottery-Game/assets/98346164/6e16116c-38d9-4a29-a9fa-5c9056432637">

<img width="109" alt="Screen Shot 2023-05-31 at 16 08 36" src="https://github.com/inomisay/Lottery-Game/assets/98346164/bca21c71-72fe-43d5-b367-6b25596e3036">

*Notes:*
1- The number of elements in the high score table is unknown, but it must contain maximum 12 items. 2- If more than one player has the same score, the older one must be added first.

# Start of the Game
At the beginning of the game, take the value of n from the user (between 7 and 10).
Each card (**Stack**) should be randomly filled with *distinct* n values. Thus, the elements in one stack must be different from each other
and must be sorted.

<img width="329" alt="Screen Shot 2023-05-31 at 16 09 40" src="https://github.com/inomisay/Lottery-Game/assets/98346164/a9795568-f3cd-488f-9f52-35f382a46e09">

# Game Playing

There are two *sorted* bags. The first bag, named bag1 (**Queue – Q3**), initially includes all suit values. In other words, it initially contains all lottery balls. The program randomly selects a lottery ball from the bag1 and removes it. Selected balls are added to another bag, named bag2 (**Queue – Q4**). Therefore, in each iteration, the next ball is selected from the remaining balls.
The program should continuously select a ball from the bag1. The selected value should be deleted from the bag1 and inserted into the bag2.

<img width="584" alt="Screen Shot 2023-05-31 at 16 10 16" src="https://github.com/inomisay/Lottery-Game/assets/98346164/84201cfc-ff35-4450-b9dd-e8bd25a8c2f6">

Each player deletes the selected value from his/her stack if it exists and gets 10 score points. If the card of the player does not contain the selected value the player losses 5 points.
The first player that deletes 4 elements from his/her stack completes the first tournament and gets the award score 30. (“birinci çinko”) When a player deletes all elements from his/her stack, he/she gets the award score 50.
If both players delete their last elements at the same time, they share the score.
The program must display all steps until the game is over. In other words, the program must continuously print the S1, S2, Q3, Q4, and the scores on the screen.

# End of the Game

The game is over when a card becomes empty.
The winner will be the player that has higher score.
If two players have the same score, the game is over without any winner (tie).

# High Score Table

If the player earns a score within the top results, he/she will be displayed in the High-Score table.
Add into the queue Q1 and Q2. If the same score exists in the table, the new score should be inserted to the next of them. Delete the last record if it is required since the table must contain maximum 12 items.
The new score table should be written to the same file (“D:\\HighScoreTable.txt”).

# Play again?

At the end of the game, ask to the user if he/she wants to play again.

<img width="722" alt="Screen Shot 2023-05-31 at 16 11 11" src="https://github.com/inomisay/Lottery-Game/assets/98346164/1ff4ae8b-297b-4806-b13a-fe38d65d98b1">

<img width="326" alt="Screen Shot 2023-05-31 at 16 11 19" src="https://github.com/inomisay/Lottery-Game/assets/98346164/9aef00ff-2032-4bab-add0-6fc964469e82">

**Notes**
1- In your program, you can use the **stack** and **queue** data structures as you want, but you must use **only** *stack* and *queue*. **Don’t use** other data structures such as an *array* or *arraylist* or *list*.
*Don’t use STRING* data type in the main solution, instead of a stack or queue.
2- The stack class has only the following methods: push, pop, peek, isFull, isEmpty, and size. Don’t add a new method into the stack class.
For example, don’t write a *display* method in the Stack class. 
For example, don’t write a *search* method in the Stack class.
All other methods **must** be written in the **main** program.
3- The queue class has only the following methods: enqueue, dequeue, peek, isFull, isEmpty, and size.
Don’t add a new method into the Queue class.
For example, don’t write a *display* method in the Queue class.
For example, don’t write a *search* method in the Queue class. 
All other methods **must** be written in the **main** program.
4- You can use **linear queue** or **circular queue**.
5- Don’t use stack and queue classes embedded in Java. Write your own Stack and Queue classes.
6- Don’t use **ENIGMA** or any other extra library.
7- Your program must work correctly under all conditions. Try to control all possible errors.
8- You should use meaningful variable names, appropriate comments, and good prompting messages.
