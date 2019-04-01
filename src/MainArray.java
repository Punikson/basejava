public class MainArray {

    public static void main(String[] args) {
        Resume resume = new Resume("Первое");
        Resume resume2 = new Resume("Второе");
        Resume resume3 = new Resume("Третье");
        Resume resume4 = new Resume("Четвертое");
        ArrayStorage storageOfResumes = new ArrayStorage();
        storageOfResumes.save(resume);
        storageOfResumes.save(resume2);
        storageOfResumes.save(resume3);
        storageOfResumes.save(resume4);
        System.out.print(storageOfResumes.get(0) + " " + storageOfResumes.get(1) + " " + storageOfResumes.get(2));
        System.out.print("" + " " + storageOfResumes.get(3) + " " + storageOfResumes.get(4));
        storageOfResumes.delete("Второе");
        System.out.printf("\n");
        System.out.print(storageOfResumes.get(0) + " " + storageOfResumes.get(1) + " " + storageOfResumes.get(2));
        System.out.print("" + " " + storageOfResumes.get(3) + " " + storageOfResumes.get(4));
        System.out.printf("\n");
        //storageOfResumes.clear();
        System.out.print(storageOfResumes.get(0) + " " + storageOfResumes.get(1) + " " + storageOfResumes.get(2));
        System.out.print("" + " " + storageOfResumes.get(3) + " " + storageOfResumes.get(4));
        storageOfResumes.getAll();

    }
}
