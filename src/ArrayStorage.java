public class ArrayStorage {
    public static int count = 0;
    public Resume[] storage = new Resume[2];

    public void save(Resume res){
    if (storage[0]==null)
        storage[0] = res;
    else
        storage[count+1] = res;
    }
    Resume get(int i){

        return storage[i];
    }
    void delete(){

    }

    void clear(){

    }

    public static void main(String[] args) {
        Resume resume = new Resume("Первое");
        Resume resume2 = new Resume("Второе");
        ArrayStorage storageOfResumes = new ArrayStorage();
        storageOfResumes.save(resume);
        storageOfResumes.save(resume2);
        System.out.println(storageOfResumes.get(0) + " " + storageOfResumes.get(1));


    }

}
