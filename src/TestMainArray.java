public class TestMainArray {
    private final static  Storage STORAGE_OF_RESUMES = new ArrayStorage();

    public static void main(String[] args) {
       final Resume res = new Resume("Первое");
       final Resume res2 = new Resume("Второе");
       final Resume res3 = new Resume("Третье");
       final Resume res4 = new Resume("Четвертое");
       final Resume res5 = new Resume("Четверт");

        STORAGE_OF_RESUMES.save(res);
        STORAGE_OF_RESUMES.save(res2);
        STORAGE_OF_RESUMES.save(res3);
        STORAGE_OF_RESUMES.save(res4);
        System.out.println("Get r1: " + STORAGE_OF_RESUMES.get(res.getUuId()));
        System.out.println("Size: " + STORAGE_OF_RESUMES.size());
        System.out.println("Get dummy: " + STORAGE_OF_RESUMES.get("dummy"));
        printAll();
        STORAGE_OF_RESUMES.delete(res.getUuId());
        printAll();
        System.out.println("Size: " + STORAGE_OF_RESUMES.size());
        STORAGE_OF_RESUMES.update(res5);
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