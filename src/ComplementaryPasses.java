public class ComplementaryPasses{
    private String passID;
    private String accessLevel;

    public ComplementaryPasses(String passID ,String accessLevel){
        this.accessLevel=accessLevel;
        this.passID = passID;
    }

    public void setPassID(String passID){
        this.passID=passID;
    }

    public String getPassID(String passID){
        return passID;
    }

    public void setAccessLevel (String accessLevel){
        this.accessLevel=accessLevel;
    }

    public String getAccessLevel (String accessLevel){
        return accessLevel;
    }

    public String toString(){
        return "ComplementaryPasses{PassID='"+passID+"',AccessLevel'"+accessLevel+"'}";
    }
}