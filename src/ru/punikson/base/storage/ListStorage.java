package ru.punikson.base.storage;

import ru.punikson.base.model.Resume;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private final List<Resume> list = new ArrayList<>();

    @Override
    protected void doSave(Object searchKey, Resume r) {
        list.add(r);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    protected void doUpdate(Object searchKey, Resume r) {
        list.set((Integer) searchKey, r);
    }

    @Override
    protected void doDelete(Object searchKey) {

    }

    @Override
    public void clear() {

    }

    @Override
    protected Resume doGet(Object searchKey) {
        return null;
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Resume res = (Resume) it.next();
            if (res.getUuId().equals(uuid))
                return list.indexOf(res);
        }
        return null;
    }
}
