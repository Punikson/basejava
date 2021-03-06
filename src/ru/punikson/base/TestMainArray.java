package ru.punikson.base;

import ru.punikson.base.model.Resume;
import ru.punikson.base.storage.*;

public class TestMainArray {
    private final static Storage STORAGE_OF_RESUMES = new ListStorage();

    public static void main(String[] args) {
        final Resume res = new Resume("res2");
        final Resume res2 = new Resume("res4");
        final Resume res3 = new Resume("res1");
        final Resume res4 = new Resume("res3");
        final Resume res5 = new Resume("res5");

        STORAGE_OF_RESUMES.save(res);
        STORAGE_OF_RESUMES.save(res2);
        STORAGE_OF_RESUMES.save(res3);
        STORAGE_OF_RESUMES.save(res4);
        System.out.println("Get r1: " + STORAGE_OF_RESUMES.get(res.getUuId()));
        System.out.println("Size: " + STORAGE_OF_RESUMES.size());
       // System.out.println("Get dummy: " + STORAGE_OF_RESUMES.get("dummy"));
        printAll();
        STORAGE_OF_RESUMES.delete(res.getUuId());
        printAll();
        System.out.println("Size: " + STORAGE_OF_RESUMES.size());
        STORAGE_OF_RESUMES.update(res4);
        printAll();
        STORAGE_OF_RESUMES.clear();
        printAll();
        System.out.println("Size: " + STORAGE_OF_RESUMES.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : STORAGE_OF_RESUMES.getAll()) {
            System.out.println(r);
        }
    }
}