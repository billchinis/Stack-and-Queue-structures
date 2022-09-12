# Queue
IntQueueImpl.java implements the interface IntQueue.java and there is a simple application in NetBenefit.java. Where the implemented queue is used to solve a basic logistics problem. Let's say we bought 50 stocks for the price of 25 euros each. Some time after that we bought 40 stocks for the price of 22 euros each and after that 30 stocks for the price of 32 euros each. And then we decide to sell 110 stocks out of the 120 we have for the price of 30 euros each. The logistic principal that is used to calculate the net profit is based on the FIFO protocol. Therefore the net profit x is x = 50(30-25) + 40(30-22) + 20(30-33) = 510. This means we sell all 50 stocks that we bought first then all 40 stocks and then the rest until we reach 110.

# Files
IntQueue.java: queue interface.
IntQueueImpl.java: queue implementation.
ListNode.java: Singly linked list implementation.
NetBenefit.java: Main program that uses all the above to solve a basic logistics problem.
example.txt: Simple example.

# HowTo
Open cmd in the same folder as the files and run the commands below.

example.txt has the specific format buy x price y, sell z price w

`javac NetBenefit.java`

`java NetBenefit example.txt`
