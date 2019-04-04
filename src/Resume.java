public class Resume {
    private String uuID;

    public Resume() {
        System.out.println("Error. Resume with this uuid is not in the storage");
    }

    public Resume(String uuID) {
        this.uuID = uuID;
    }

    public String getUuId() {
        return this.uuID;
    }

    public void setUuID(String uuID) {
        this.uuID = uuID;
    }

    @Override
    public String toString() {
        return this.uuID;
    }
}
