Distributed_System_Lab
COMP212-assignment1 

Copyright ©Zheyu.Zhang	

How to run the code:
IDE: Apache Netbeans IDE 11.1

The program is a simulator for sloving leader election problem within a closed-ring in varying sizes. LCR and HS are the two tested algorithms in this simulator. 

1. Functionality:
This project contains three classes, two object classes, which are message and node respectively, and one main class.
The object node can communicate with another node. Every node can send and receive information from another node. Every node has its unique identification.
It is informed that in LCR algorithm one node can only communicate with its clockwise neighbour while in the HS algorithm it can communicate with both clockwise neighbour and counterclockwise neighbour.
The object message transmits information between node and node.
There are mainly 6 methods in "main" class. 
(1) MakeNodeRing(int size): 
i)this method can produce a ring which consist of node objects. The initial state of the method is to produce a set of random distinct integer arraylist. 
ii)if you wish to arrange the unique ids as clockwise or counterclockwise ordered, replace the randomInt in the second line as CorderedInt or orderedInt.
iii)This method returns an array of node, which is our node ring.

(2)LCR(node[ ] arrayOfNode): 
It's the implementation of the LCR algorithm. The node information will be specified every round and the final results will be in the end. 
It should use makeNodeRing method as parameter when invoked.

(3)HS(node[ ] arrayOfNode):
Implementation of the HS algorithm.

(4)randomInts():
Produce an array of distinct integers with parameter integer 'size'. The maximum size of this method seems cannot exceed 150.
Update 03/03/2020 
The maximun size is now unlimited

(5)orderedInts()/CorderedInts:
Produce an array of unique id in clockwise/counterclockwise order. The size of these two methods can be changed with parameter integer 'size' and the size is not limited.


2. How to get started
Size is the variable appeared explicitly, so it is not difficult to get started. In the main method, you can also simply type HSTest(size) or LCRTest(Size) to test these two algorithms. If you prefer the prue results, it's recommanded that you commented all the print function.
Another variable you should pay attention is the nodes' order. In case you have not notice the tips below ,the second line of the makeNodeRing() method can be changed to get the results in different situation.
Type int[] arrayOfInt = CorderedInts(arrayOfNode.length); there you will get counterclockwise ordered ring.
Type int[] arrayOfInt = orderedInts(arrayOfNode.length);--clockwise
int[] arrayOfInt = CorderedInts(arrayOfNode.length); ------ random ordered.

3. Example input:
Type LCR( makeNodeRing(100)); in the main method, which will test the LCR algorithm in size equals 100, and the output goes like the following:

4. Example output:
i).The node in clockwiseorder
the array length is 10
After 11 rounds, the leader is elected
###################################result###########################################
in round 11 the node with unique id 9 is elected as leader. There are 19 messages currently
After 20 round, all nodes are terminated. There are 119 messages in total.

ii).In counterclockwise order
the array length is 10
in round 11 the first node whith unique id 9 is elected as leader
After 11 rounds, the leader is elected
###################################result###########################################
in round 11 the node with unique id 9 is elected as leader. There are 55 messages currently
After 20 round, all nodes are terminated. There are 146 messages in total.

iii).In random order
the array length is 10
in round 11 the 6th node with unique id 10 is elected as leader
After 11 rounds, the leader is elected
###################################result###########################################
in round 11 the node with unique id 9 is elected as leader. There are 27 messages currently
After 20 round, all nodes are terminated. There are 123 messages in total.
P.S.
It is an assignment for Y2 COMP212 student in UOL. Since the limited time and approached deadline, this simulator isn't built perfectly as expected, especially in the LCR part. Furthermore, if you find some definitions, comments might seemed meaningless to you, you are probably right.Cuz there are some obsoleting ideas and setting that haven't been cleaned up, just ignore them.
The message object was introduced when i just finished the LCR part and started HS, hence it seems a little werid that the LCR algorithm contains no message object. Anyway, it still a good simulator. I will keep update these two algorithm if available.
Lastly is some tips for the assignment:
1.You might be confused about the complexity in this module. For example, a complexity expressed as O(log n) means that if the size increased to n times as before, the number of (messages/ rounds/ runtime) will increased to log n times than before.
It has to be informed that this (log⁡ n) here represents the binary logarithm which base on integer 2. Or simply (log 2 n).
Another important tip is that all the given theorical complexity equation always indicates the worst case equation, like the HS communication complexity O(nlogn). Hence you should focus on the maximum numbers of message in each size to prove it, or simply just write another few lines searching the maximum number of messages. Hope it can help.
To the student in UOL studying COMP212 or major in CSEE or anyone else in the world who has read this file:
Feel free to utilize these little files, but make sure you are not simply copied. I am glad to join the open-sourcing world. Hope you have hun too.
