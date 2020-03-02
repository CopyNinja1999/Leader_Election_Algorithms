# Leader_Election_Algorithms
Distributed_System_Lab
COMP212-assignment1 

Copyright ©Zheyu.Zhang	

How to run the code:
IDE: Apache Netbeans IDE 11.1

The program is a simulator for sloving leader election problem within a closed-ring in varying sizes. LCR and HS are the two tested algorithms in this simulator. 

1. There are 6 methods in "main" class. 
(1) MakeNodeRing(): 
i)this method can produce a ring which consist of node objects. The initial state of the method is to produce a set of random distinct integer arraylist. 
ii)if you wish to arrange the unique ids as clockwise or counterclockwise ordered, replace the randomInt in the second line as CorderedInt or orderedInt.
iii)This method returns an array in int type.

(2)LCR(): 
It's the implementation of the LCR algorithm. The node information will be specified every round and the final results will be in the end. 
It should use makeNodeRing method as parameter when invoked.

(3)HS():
Implementation of the HS algorithm.

(4)randomInts():
Produce an array of distinct integers with parameter integer 'size'. The maximum size of this method seems cannot exceed 150.

(5)orderedInts()/CorderedInts:
Produce an array of unique id in clockwise/counterclockwise order. The size of these two methods can be changed with parameter integer 'size' and the size is not limited.


2. In the main method, you can simply type HSTest(size) or LCRTest(Size) to test these two algorithms. If you would like the prue results, it's recommanded that you commented all the print function.
3. Example input:
Type LCR( makeNodeRing(100)); in the main method, which will test the LCR algorithm in size equals 100, and the output goes like the following:

4. Example output:

the array length is 10
----------round 1----------

number# uid# mid# inid# status
0     # 7  # 7  # 1  # unknown
1     # 5  # 5  # 7  # unknown
2     # 0  # 0  # 5  # unknown
3     # 3  # 3  # 0  # unknown
4     # 8  # 8  # 3  # unknown
5     # 2  # 2  # 8  # unknown
6     # 4  # 4  # 2  # unknown
7     # 9  # 9  # 4  # unknown
8     # 6  # 6  # 9  # unknown
9     # 1  # 1  # 6  # unknown
----------round 2----------

number# uid# mid# inid# status
0     # 7  # 7  # 1  # unknown
1     # 5  # 7  # 7  # unknown
2     # 0  # 5  # 5  # unknown
3     # 3  # 3  # 0  # unknown
4     # 8  # 8  # 3  # unknown
5     # 2  # 8  # 8  # unknown
6     # 4  # 4  # 2  # unknown
7     # 9  # 9  # 4  # unknown
8     # 6  # 9  # 9  # unknown
9     # 1  # 6  # 6  # unknown
----------round 3----------

number# uid# mid# inid# status
0     # 7  # 7  # 6  # unknown
1     # 5  # 7  # 7  # unknown
2     # 0  # 7  # 7  # unknown
3     # 3  # 5  # 5  # unknown
4     # 8  # 8  # 3  # unknown
5     # 2  # 8  # 8  # unknown
6     # 4  # 8  # 8  # unknown
7     # 9  # 9  # 4  # unknown
8     # 6  # 9  # 9  # unknown
9     # 1  # 9  # 9  # unknown
----------round 4----------

number# uid# mid# inid# status
0     # 7  # 9  # 9  # unknown
1     # 5  # 7  # 7  # unknown
2     # 0  # 7  # 7  # unknown
3     # 3  # 7  # 7  # unknown
4     # 8  # 8  # 5  # unknown
5     # 2  # 8  # 8  # unknown
6     # 4  # 8  # 8  # unknown
7     # 9  # 9  # 8  # unknown
8     # 6  # 9  # 9  # unknown
9     # 1  # 9  # 9  # unknown
----------round 5----------

number# uid# mid# inid# status
0     # 7  # 9  # 9  # unknown
1     # 5  # 9  # 9  # unknown
2     # 0  # 7  # 7  # unknown
3     # 3  # 7  # 7  # unknown
4     # 8  # 8  # 7  # unknown
5     # 2  # 8  # 8  # unknown
6     # 4  # 8  # 8  # unknown
7     # 9  # 9  # 8  # unknown
8     # 6  # 9  # 9  # unknown
9     # 1  # 9  # 9  # unknown
----------round 6----------

number# uid# mid# inid# status
0     # 7  # 9  # 9  # unknown
1     # 5  # 9  # 9  # unknown
2     # 0  # 9  # 9  # unknown
3     # 3  # 7  # 7  # unknown
4     # 8  # 8  # 7  # unknown
5     # 2  # 8  # 8  # unknown
6     # 4  # 8  # 8  # unknown
7     # 9  # 9  # 8  # unknown
8     # 6  # 9  # 9  # unknown
9     # 1  # 9  # 9  # unknown
----------round 7----------

number# uid# mid# inid# status
0     # 7  # 9  # 9  # unknown
1     # 5  # 9  # 9  # unknown
2     # 0  # 9  # 9  # unknown
3     # 3  # 9  # 9  # unknown
4     # 8  # 8  # 7  # unknown
5     # 2  # 8  # 8  # unknown
6     # 4  # 8  # 8  # unknown
7     # 9  # 9  # 8  # unknown
8     # 6  # 9  # 9  # unknown
9     # 1  # 9  # 9  # unknown
----------round 8----------

number# uid# mid# inid# status
0     # 7  # 9  # 9  # unknown
1     # 5  # 9  # 9  # unknown
2     # 0  # 9  # 9  # unknown
3     # 3  # 9  # 9  # unknown
4     # 8  # 9  # 9  # unknown
5     # 2  # 8  # 8  # unknown
6     # 4  # 8  # 8  # unknown
7     # 9  # 9  # 8  # unknown
8     # 6  # 9  # 9  # unknown
9     # 1  # 9  # 9  # unknown
----------round 9----------

number# uid# mid# inid# status
0     # 7  # 9  # 9  # unknown
1     # 5  # 9  # 9  # unknown
2     # 0  # 9  # 9  # unknown
3     # 3  # 9  # 9  # unknown
4     # 8  # 9  # 9  # unknown
5     # 2  # 9  # 9  # unknown
6     # 4  # 8  # 8  # unknown
7     # 9  # 9  # 8  # unknown
8     # 6  # 9  # 9  # unknown
9     # 1  # 9  # 9  # unknown
----------round 10----------

number# uid# mid# inid# status
0     # 7  # 9  # 9  # unknown
1     # 5  # 9  # 9  # unknown
2     # 0  # 9  # 9  # unknown
3     # 3  # 9  # 9  # unknown
4     # 8  # 9  # 9  # unknown
5     # 2  # 9  # 9  # unknown
6     # 4  # 9  # 9  # unknown
7     # 9  # 9  # 8  # unknown
8     # 6  # 9  # 9  # unknown
9     # 1  # 9  # 9  # unknown
----------round 11----------

number# uid# mid# inid# status
0     # 7  # 9  # 9  # unknown
1     # 5  # 9  # 9  # unknown
2     # 0  # 9  # 9  # unknown
3     # 3  # 9  # 9  # unknown
4     # 8  # 9  # 9  # unknown
5     # 2  # 9  # 9  # unknown
6     # 4  # 9  # 9  # unknown
in round 11 the 8th node with unique id 9 is elected as leader
7     # 9  # 9  # 9  # leader
8     # 6  # 9  # 9  # unknown
9     # 1  # 9  # 9  # unknown
After 11 rounds, the leader is elected
----------round 11----------

number# uid# mid# inid# status
0     # 7  # 9  # 9  # unknown
1     # 5  # 9  # 9  # unknown
2     # 0  # 9  # 9  # unknown
3     # 3  # 9  # 9  # unknown
4     # 8  # 9  # 9  # unknown
5     # 2  # 9  # 9  # unknown
6     # 4  # 9  # 9  # unknown
7     # 9  # 9  # 9  # leader
8     # 6  # 9  # 9  # terminated
9     # 1  # 9  # 9  # unknown
----------round 12----------

number# uid# mid# inid# status
0     # 7  # 9  # 9  # unknown
1     # 5  # 9  # 9  # unknown
2     # 0  # 9  # 9  # unknown
3     # 3  # 9  # 9  # unknown
4     # 8  # 9  # 9  # unknown
5     # 2  # 9  # 9  # unknown
6     # 4  # 9  # 9  # unknown
7     # 9  # 9  # 9  # leader
8     # 6  # 9  # 9  # terminated
9     # 1  # 9  # 9  # terminated
----------round 13----------

number# uid# mid# inid# status
0     # 7  # 9  # 9  # terminated
1     # 5  # 9  # 9  # unknown
2     # 0  # 9  # 9  # unknown
3     # 3  # 9  # 9  # unknown
4     # 8  # 9  # 9  # unknown
5     # 2  # 9  # 9  # unknown
6     # 4  # 9  # 9  # unknown
7     # 9  # 9  # 9  # leader
8     # 6  # 9  # 9  # terminated
9     # 1  # 9  # 9  # terminated
----------round 14----------

number# uid# mid# inid# status
0     # 7  # 9  # 9  # terminated
1     # 5  # 9  # 9  # terminated
2     # 0  # 9  # 9  # unknown
3     # 3  # 9  # 9  # unknown
4     # 8  # 9  # 9  # unknown
5     # 2  # 9  # 9  # unknown
6     # 4  # 9  # 9  # unknown
7     # 9  # 9  # 9  # leader
8     # 6  # 9  # 9  # terminated
9     # 1  # 9  # 9  # terminated
----------round 15----------

number# uid# mid# inid# status
0     # 7  # 9  # 9  # terminated
1     # 5  # 9  # 9  # terminated
2     # 0  # 9  # 9  # terminated
3     # 3  # 9  # 9  # unknown
4     # 8  # 9  # 9  # unknown
5     # 2  # 9  # 9  # unknown
6     # 4  # 9  # 9  # unknown
7     # 9  # 9  # 9  # leader
8     # 6  # 9  # 9  # terminated
9     # 1  # 9  # 9  # terminated
----------round 16----------

number# uid# mid# inid# status
0     # 7  # 9  # 9  # terminated
1     # 5  # 9  # 9  # terminated
2     # 0  # 9  # 9  # terminated
3     # 3  # 9  # 9  # terminated
4     # 8  # 9  # 9  # unknown
5     # 2  # 9  # 9  # unknown
6     # 4  # 9  # 9  # unknown
7     # 9  # 9  # 9  # leader
8     # 6  # 9  # 9  # terminated
9     # 1  # 9  # 9  # terminated
----------round 17----------

number# uid# mid# inid# status
0     # 7  # 9  # 9  # terminated
1     # 5  # 9  # 9  # terminated
2     # 0  # 9  # 9  # terminated
3     # 3  # 9  # 9  # terminated
4     # 8  # 9  # 9  # terminated
5     # 2  # 9  # 9  # unknown
6     # 4  # 9  # 9  # unknown
7     # 9  # 9  # 9  # leader
8     # 6  # 9  # 9  # terminated
9     # 1  # 9  # 9  # terminated
----------round 18----------

number# uid# mid# inid# status
0     # 7  # 9  # 9  # terminated
1     # 5  # 9  # 9  # terminated
2     # 0  # 9  # 9  # terminated
3     # 3  # 9  # 9  # terminated
4     # 8  # 9  # 9  # terminated
5     # 2  # 9  # 9  # terminated
6     # 4  # 9  # 9  # unknown
7     # 9  # 9  # 9  # leader
8     # 6  # 9  # 9  # terminated
9     # 1  # 9  # 9  # terminated

----------round 19----------
number# uid# mid# inid# status
0     # 7  # 9  # 9  # terminated
1     # 5  # 9  # 9  # terminated
2     # 0  # 9  # 9  # terminated
3     # 3  # 9  # 9  # terminated
4     # 8  # 9  # 9  # terminated
5     # 2  # 9  # 9  # terminated
6     # 4  # 9  # 9  # terminated
7     # 9  # 9  # 9  # leader
8     # 6  # 9  # 9  # terminated
9     # 1  # 9  # 9  # terminated
----------round 20----------

number# uid# mid# inid# status
0     # 7  # 9  # 9  # terminated
1     # 5  # 9  # 9  # terminated
2     # 0  # 9  # 9  # terminated
3     # 3  # 9  # 9  # terminated
4     # 8  # 9  # 9  # terminated
5     # 2  # 9  # 9  # terminated
6     # 4  # 9  # 9  # terminated

###################################result###########################################

in round 11 the node with unique id 9 is elected as leader
After 20 round, all nodes are terminated. There are 208 messages in total.



P.S.
It is an assignment for Y2 COMP212 in UOL. Since the limited time and approached deadline, this simulator isn't built perfectly, especially in the HS part. This message object was introduced when i just finished the 
LCR part and started HS, hence it seems a little werid that the LCR algorithm contains no message object. Anyway, it still a good simulator.
