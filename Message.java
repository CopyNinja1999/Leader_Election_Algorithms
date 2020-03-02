public class Message {
private int inid;
private int hopCount=0;
private int mcount=0;
private int phase=0;
private boolean state=true;// True equals out, false equals in
private boolean CWF=false;//clockwiseflag, true equals in
private boolean CCWF=false;

public Message(int id){
this.inid=id;
this.hopCount=(int)Math.pow(2, phase);
}
    public Message(int id,int phase){
this.inid=id;
this.phase=phase;

    }
public int GetMcount(){return mcount;}

public void SetMcount(){this.mcount+=1;}
 public boolean GetState(){
     return state;}  
public int GetInid(){return inid;} 
public void SetState(){
this.state=!state;}
public int GetHCount(){return hopCount;}
public void resetHCount(){
this.hopCount=(int)Math.pow(2, phase);}
public void setHCount(){
this.hopCount-=1;}
public void phaseIncrement(){phase+=1;
System.out.println("Message with id "+inid+" is now phase "+ phase);
}  
public int Getphase(){return phase;}
public void reset(){
this.hopCount=(int)Math.pow(2, phase);
this.CCWF=false;
this.CWF=false;
}
public void setCWF(){
this.CWF=!CWF;}
public void setCCWF(){
this.CCWF=true;}
public boolean GetCWF(){return CWF;}
public boolean GetCCWF(){return CCWF;}

public void tostring(){
    if(CCWF & CWF){
    System.out.println("CCWF=True "+"True");}
    else if(!CCWF & CWF){
    System.out.println("CCWF=False "+"True");
    }
    else if(CCWF & !CWF){
    System.out.println("CCWF=True "+"False");}
    else{
    System.out.println("CCWF=False "+"False");
    }
    
}
    public String MShowInfo(boolean F){
    if(F){
    return"<"+inid+", in, "+hopCount+", "+phase+">";}
    else{return "<"+inid+", out, "+hopCount+", "+phase+">";}
    }
}
