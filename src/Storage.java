public interface Storage {
    public void save(Resume res);

    public Resume get(String uuid);


    public void update(Resume res);

    public void delete(String uuid);

    public int size();
    public void clear();

    public Resume[] getAll();

    public int getIndex(String uuid);
}
