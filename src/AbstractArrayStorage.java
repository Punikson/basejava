public abstract class AbstractArrayStorage implements Storage{
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int count = 0;

    public int size() {
        return count;
    }

    public Resume get(String uuid) {
        int result = getIndex(uuid);
        if (result != -1) {
            return storage[result];
        }
        System.out.println("Error. Resume with this uuid is not in the storage");

        return null;
    }

    protected abstract int getIndex(String uuid);
}




