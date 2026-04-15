import java.util.ArrayList;

class PersonList {
  private String name;
  private String tel;
  private int id;  
  private int age; 

  PersonList(String name, String phoneNumber, int id, int age) {
    this.name = name;
    this.tel = phoneNumber;
    this.id = id;
    this.age = age;
  }

  public String getName() { return name; }
  public String getPhone() { return tel; }
  public int getId() { return id; }
  public int getAge() { return age; }
}

class PhoneBookList {
  private ArrayList phoneBook;

  public PhoneBookList() {
    phoneBook = new ArrayList();
  }

  public void add(String name, String phoneNumber, int id, int age) {
    PersonList p = new PersonList(name, phoneNumber, id, age);
    phoneBook.add(p);
  }

  public String lookup(String name) {
    PersonList p;
    for (int i = 0; i < phoneBook.size(); i++) {
      p = (PersonList) phoneBook.get(i);
      if (p.getName().equals(name))
        return p.getPhone();
    }
    return null;
  }

  public String lookup(int id) {
    PersonList p;
    for (int i = 0; i < phoneBook.size(); i++) {
      p = (PersonList) phoneBook.get(i);
      if (p.getId() == id)
        return p.getPhone();
    }
    return null;
  }
}

public class PhoneBookTest_ArrayList {
  public static void main(String[] args) {
    PhoneBookList phoneBook = new PhoneBookList();

    phoneBook.add("홍봄", "010-123-5678", 101, 20);
    phoneBook.add("정여름", "011-765-2389", 102, 22);
    phoneBook.add("김가을", "011-432-8765", 103, 25);
    phoneBook.add("이겨울", "019-234-5645", 104, 21);

    System.out.println("--- ArrayList 버전 검색 결과 ---");

    String nameToSearch = "홍봄";
    String phoneByName = phoneBook.lookup(nameToSearch);
    System.out.println("이름 검색 (" + nameToSearch + "): " + (phoneByName == null ? "찾을 수 없음" : phoneByName));

    int idToSearch = 102;
    String phoneById = phoneBook.lookup(idToSearch);
    System.out.println("ID 검색 (" + idToSearch + "): " + (phoneById == null ? "찾을 수 없음" : phoneById));
  }
}
