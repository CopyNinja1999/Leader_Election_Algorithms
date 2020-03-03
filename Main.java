package com.mycompany.distributedsystemlab;


import java.util.LinkedList;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     LCR( makeNodeRing(5));
//        randomInts(20);
//LCRTest(10);
//HSTest(10);
    }
    public static void LCRTest(int size){
        LCR(makeNodeRing(size));
    
    }
    public static void HSTest(int size){
       HS(makeNodeRing(size));}
  public static node[] makeNodeRing(int size) {
    node[] arrayOfNode = new node[size];//set up number=size nodes
    int[] arrayOfInt = CorderedInts(arrayOfNode.length);
//create a set of distinct integers
// if you wish to make it clockwise or counterclockwise ordered, replace the randomInts as CorderedInts or orderedInts
    Message[] arrayOfMessage=new Message[arrayOfNode.length];
    
    int b;
   System.out.println("the array length is "+arrayOfNode.length);
    for (b = 0; b <= arrayOfNode.length - 1; b++){
        
        arrayOfNode[b]=new node(arrayOfInt[b]);
        arrayOfMessage[b]=new Message(arrayOfNode[b].GetID());
    arrayOfNode[b].SetMessage(arrayOfMessage[b]);
    }//the first node must be pre-defined
        
        for(b=0;b <= arrayOfNode.length - 1; b++)
        {  if(b==0){arrayOfNode[b].SetNeighbour(arrayOfNode[b+1],arrayOfNode[arrayOfNode.length-1]);}
        else if(b==arrayOfNode.length-1)
        {arrayOfNode[arrayOfNode.length-1].SetNeighbour(arrayOfNode[0],arrayOfNode[arrayOfNode.length-2]);}
        
        else{
      arrayOfNode[b].SetNeighbour(arrayOfNode[b+1],arrayOfNode[b-1]); //assign unique ids to every node
     //System.out.println(arrayOfNode[b].getInfo());
        }  

    }
    
  // as a ring, the last node points to the first
//  System.out.print(arrayOfNode)
 
          return arrayOfNode;
  }
  
  public static node[] LCR(node[] arrayOfNode){
   Boolean leaderflag=new Boolean(false);
    Boolean Tflag= new Boolean(false);
  int round=1;
  int mcount=0;//TODO:complete the messages counting step
  while(leaderflag==false){ 
//      System.out.println("----------round "+ round+"----------");//10 dashes each
//      System.out.println("number# uid# mid# inid# status");
      int c=0;
      for (c = 0; c <= arrayOfNode.length - 1; c++){
          
      if(c==arrayOfNode.length-1){
         
      if(arrayOfNode[arrayOfNode.length - 1].GetStatus()=="leader"){
//          System.out.println("in round "+round+ " the last node whith unique id "+arrayOfNode[0].GetID() +"is elected as leader");
          leaderflag=true;
         
      }}//in the case of out of boundry exception
      else if(c==0){arrayOfNode[arrayOfNode.length-1].LCRAlgorithm(round);
      arrayOfNode[0].LCRAlgorithm(round);
      if(arrayOfNode[0].GetStatus()=="leader"){
      System.out.println("in round "+round+" the first node whith unique id "+arrayOfNode[0].GetID() +" is elected as leader");
          leaderflag=true;
      }}                                        //In order to print the first incoming message, the last node should be excuted firstly in a for loop
      else{
      arrayOfNode[c].LCRAlgorithm(round); 
   // System.out.println("1");
      if(arrayOfNode[c].GetStatus()=="leader"){
          leaderflag=true;
          System.out.println("in round "+round+" the "+(c+1)+"th node with unique id "+arrayOfNode[c].GetID() +" is elected as leader");
          }
      }
//      System.out.println(c+"     # "+arrayOfNode[c].getInfo());
  }
     for(int b=0;b<= arrayOfNode.length - 1;b++){arrayOfNode[b].send();} 
 round++;

  
  }
  round-=1;//
     for(int c=0;c<arrayOfNode.length;c++){
       System.out.println(arrayOfNode[c].GetMessage().GetMcount());
       mcount+=arrayOfNode[c].GetMessage().GetMcount();}
//     mcount+=arrayOfNode.length;//in round 1 every node send a message
  int Fmcount=mcount;
  int Fround=round;
  System.out.println("After "+round+" rounds, the leader is elected");// which should be n-1 round
while(Tflag==false){ 
//      System.out.println("----------round "+ round+"----------");//10 dashes each
//      System.out.println("number# uid# mid# inid# status");
      int c=0;
      for (c = 0; c <= arrayOfNode.length - 1; c++){
     arrayOfNode[c].sendS();
       }
      
      for (c = 0; c <= arrayOfNode.length - 1; c++){
          mcount++;
          Tflag=arrayOfNode[c].Termination();
     if(arrayOfNode[c].Termination()){
         
     break;} 
//     System.out.println(c+"     # "+arrayOfNode[c].getInfo());
       }   
   
    round++;
}
System.out.println("###################################result###########################################");
System.out.println("in round "+Fround+" the node with unique id "+ (arrayOfNode.length-1) +" is elected as leader. There are "+Fmcount+" messages currently");

System.out.println("After "+(round-1)+" round, all nodes are terminated. There are "+mcount+" messages in total.");
  return arrayOfNode;
  }
  public static node[] HS(node[] arrayOfNode){
      int phase=0;
  int round =1;
  Boolean leaderflag= new Boolean(false);
  int mcount=0;
  
  while(!leaderflag){
  
   if(phase==0){ 
       System.out.println("----------phase"+ phase+"----------");
  for(int a=0;a<=arrayOfNode.length-1;a++){
    arrayOfNode[a].HSAlogorithm();
      
  }
   }
   else {
       System.out.println("----------phase "+ phase+"----------");
   for(int a=0;a<=arrayOfNode.length-1;a++){
   if( arrayOfNode[a].GetMessage().Getphase()==(phase)){
       
        arrayOfNode[a].HSAlogorithm();
//        if((int)Math.pow(2, (phase+2))<=arrayOfNode.length){mcount+=(int)Math.pow(2, (phase+2));}
//        else{mcount+=arrayOfNode.length;}
        if(arrayOfNode[a].GetStatus()=="leader"){
round+=arrayOfNode[a].GetMessage().GetMcount()/2;
      leaderflag=true;
        
        }
   }
   }
      
   }
   phase++;
 
  }  
  System.out.println("----------phase "+ phase+"----------");
  
   for(int c=0;c<arrayOfNode.length;c++){
   System.out.println("Node "+arrayOfNode[c].GetID()+" is now terminated");

   }
   for(int c=0;c<arrayOfNode.length;c++){
      // System.out.println(arrayOfNode[c].GetMessage().GetMcount());
       mcount+=arrayOfNode[c].GetMessage().GetMcount();}
   System.out.println("in round "+ round +", the leader is elected");
   System.out.println("There are "+ mcount + " messages in total");
   System.out.println("The final phase is" + phase);
  return arrayOfNode;}
public static int[] randomInts(int paramInt) {
int[] arrayOfInt = new int[paramInt]; // arrayOfInt is an array of random integers
for (int m = 0; m < paramInt; m++) { // m=number of the created integers
int temp = (int)(paramInt*Math.random()+1);
if (m == 0)
arrayOfInt[0] = temp;
else {
for (int n = 0; n < m; n++) { // tranversal the created random number
if (temp == arrayOfInt[n]) {
temp = (int)(paramInt*Math.random()+1);
n = -1;}}
arrayOfInt[m] = temp;}
}
return arrayOfInt;
}

// public static int[] randomInts(int paramInt) {
//    LinkedList<Integer> linkedList = new LinkedList();
//    for (byte b1 = 0; b1 < paramInt; b1++)
//      linkedList.add(Integer.valueOf(b1)); 
//    int[] arrayOfInt = new int[paramInt];
//    for (byte b2 = 0; b2 < paramInt; b2++)
//      arrayOfInt[b2] = ((Integer)linkedList.remove((int)(Math.random() * linkedList.size()))).intValue(); 
//    return arrayOfInt;
//  }
 public static int[] orderedInts (int paramInt){
 int[] arrayOfInt = new int[paramInt];
 for(int b=0;b<paramInt;b++)
 {arrayOfInt[b]=b;}
 
 return arrayOfInt;
 }
 public static int[] CorderedInts (int paramInt){
 int[] arrayOfInt = new int[paramInt];
 for(int b=0;b<paramInt;b++)
 {arrayOfInt[b]=(paramInt-1-b);}
 
 return arrayOfInt;
 }
 

}
 
