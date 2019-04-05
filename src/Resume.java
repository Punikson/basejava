public class Resume {
    private String uuid;

    public Resume(String uuID) {
        this.uuid = uuID;
    }

    public String getUuId() {
        return this.uuid;
    }

    public void setUuID(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
