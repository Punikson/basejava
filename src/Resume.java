public class Resume {
    public String uuID;

    public Resume(String uuID){
       this.uuID = uuID;
    }

    @Override
    public String toString() {
        return this.uuID;
    }
}
