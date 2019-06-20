package ru.punikson.base.storage;

import ru.punikson.base.model.Resume;

import java.util.ArrayList;
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
        list.remove((int) searchKey);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return list.get((Integer) searchKey);
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[list.size()]);
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuId().equals(uuid)) {
                return i;
            }
        }
        return null;
    }
}
