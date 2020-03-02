/**
 *
 * @author Zheyu.Zhang
 */
public class node {
private String status="unknown";
private String instatus;
private int uid;//assign unique identifiers
private int inid;//incoming id
private Message inM;//TODO: Proceed incoming message
private int mid;
private node nnode;//clockwise node
private node fnode;//counterclockwise node
private Message message;
public node(){uid=0;
mid=uid;}
public node(int Theid){
    this.uid=Theid;
    mid=uid;
}
public void SetID(int id){
this.mid=id;}
//public void SetNeighbour(node Thenext){
//this.nnode=Thenext;} 
public void SetInID(int theid){this.inid=theid;}
public int GetInID(){return inid;}
public Message GetMessage(){return message;}
public void SetMessage(Message theMessage){
this.message=theMessage;
}
public void LeaderElected(){
    this.status="leader";
// System.out.println("node with id "+mid+" is elected as leader");
}
public int GetID(){
return uid;}
public int GetmID(){return mid;}
public String GetStatus(){
return status;}
public void SetNeighbour(node Thenode, node Fnode){
this.nnode=Thenode;
this.fnode=Fnode;
}
public void send(){nnode.SetInID(mid);}
public void sendS(){nnode.setInstatus(status);}
public void setInstatus(String theStatus){this.instatus=theStatus;}
public boolean Termination(){
if(status=="leader"&instatus=="terminated"){return true;}
else if(instatus=="leader"|instatus=="terminated"){
    terminate(); 
    return false;}

return false;}



public void LCRAlgorithm(int Theround){
    
    if(Theround==1){send();}//in round 1, every node send message to clockwise neighbour
    else{
if(inid>mid){
    

SetID(inid);
}
else if(inid==uid){LeaderElected();
}

//if the incoming ID is less than existing id, nothing would happen
}}
public void ScTeriminate(){}
public void sendclockwise(Message in_M){
    in_M.SetMcount();
    if(in_M.GetCCWF() & in_M.GetInid()!=nnode.GetID()){
    nnode.sendclockwise(in_M);
    
    } //returning message statement
    else if(in_M.GetCCWF() & in_M.GetInid()==nnode.GetID()){}
    // if the sender received this returned message, which is inid= myid, do nothing.
  
    else{
    if(in_M.GetHCount()==1 & in_M.GetInid()>nnode.GetID()){
        in_M.setCWF();
    nnode.sendcounterclockwise(in_M);
    }//message returned 
    else if (in_M.GetHCount()>1 & in_M.GetInid()>nnode.GetID()){
    in_M.setHCount();
    nnode.sendclockwise(in_M);//
    }
    else if(in_M.GetInid()==nnode.GetID()){
    nnode.LeaderElected();
    }
//    System.out.println(in_M.MShowInfo(in_M.GetCWF()));
    }}


public void sendcounterclockwise(Message in_M){
    in_M.SetMcount();
 if(in_M.GetCWF() & in_M.GetInid()!=fnode.GetID())//if cwf= true, which means state=in
    {fnode.sendcounterclockwise(in_M);
//   System.out.println(in_M.MShowInfo(in_M.GetCCWF()));
    }
 else if(in_M.GetCWF() & in_M.GetInid()==fnode.GetID()){}
// if the sender received this returned message, do nothing
 else{
    if(in_M.GetHCount()==1 & in_M.GetInid()>fnode.GetID()){
        in_M.setCCWF();
    fnode.sendclockwise(in_M);
    }//message returned 
    else if (in_M.GetHCount()>1 & in_M.GetInid()>fnode.GetID()){
    in_M.setHCount();
    fnode.sendcounterclockwise(in_M); //recrusive loop 
    }//TODO 
    else if(in_M.GetInid()==fnode.GetID()){
    fnode.LeaderElected();
    //if the incoming id<myid, the message is lost
    }}


}
public void ReceiveMessage(Message M){
if(message.GetCWF()&message.GetCCWF())//clockwise and counterclockwise message returned
{message.phaseIncrement();}

else if(status!="leader"){System.out.println("Message with id "+message.GetInid()+" is discarded");
//System.out.println(message.MShowInfo(true));
}
else{System.out.println("Message with id "+message.GetInid()+" is elected as leader");}
}
public void HSAlogorithm(){
message.reset();
sendclockwise(message);
if(message.GetCWF()){message.setCWF();
message.resetHCount();
sendcounterclockwise(message);
message.setCWF();
}
else{message.resetHCount();
sendcounterclockwise(message);}
// though the two direction are required to preceed simultaneously, in java it has to be simulated as so.

ReceiveMessage(message);
 
 




}




public node getNnode(){return nnode;}
public node getFnode(){return fnode;}
public void terminate(){this.status="terminated";
//System.out.println("node with id "+uid+" is terminated");
}
public String getInfo(){
return uid+"  # "+mid+"  # "+inid+"  # "+status ;
}
}
