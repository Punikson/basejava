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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
