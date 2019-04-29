package ru.punikson.base.storage;
import ru.punikson.base.model.Resume;

public interface Storage {

     void save(Resume res);

     Resume get(String uuid);

     void update(Resume res);

     void delete(String uuid);

     int size();

     void clear();

     Resume[] getAll();
}
