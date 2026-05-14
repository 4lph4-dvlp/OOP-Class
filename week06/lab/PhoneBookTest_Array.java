class Person {
  private String name;
  private String tel;
  private int id;
  private int age;

  Person(String name, String phoneNumber, int id, int age) {
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

class PhoneBook {
  private Person[] book;
  private int count;

  public PhoneBook(int max) {
    book = new Person[max];
    count = 0;
  }

  public void add(String name, String phoneNumber, int id, int age) {
    if (count == book.length) {
      System.out.println("주소록 넘침");
    } else {
      book[count] = new Person(name, phoneNumber, id, age);
      count++;
    }
  }

  public String lookup(String name) {
    for (int i = 0; i < count; i++) {
      if (book[i].getName().equals(name))
        return book[i].getPhone();
    }
    return null;
  }

  public String lookup(int id) {
    for (int i = 0; i < count; i++) {
      if (book[i].getId() == id)
        return book[i].getPhone();
    }
    return null;
  }
}

public class PhoneBookTest_Array {
  public static void main(String[] args) {
    PhoneBook phoneBook = new PhoneBook(100);

    phoneBook.add("홍봄", "010-123-5678", 101, 20);
    phoneBook.add("정여름", "011-765-2389", 102, 22);
    phoneBook.add("김가을", "011-432-8765", 103, 25);
    phoneBook.add("이겨울", "019-234-5645", 104, 21);

    System.out.println("--- 배열 버전 검색 결과 ---");

    String nameToSearch = "김가을";
    String phoneByName = phoneBook.lookup(nameToSearch);
    System.out.println("이름 검색 (" + nameToSearch + "): " + (phoneByName == null ? "찾을 수 없음" : phoneByName));

    int idToSearch = 104;
    String phoneById = phoneBook.lookup(idToSearch);
    System.out.println("ID 검색 (" + idToSearch + "): " + (phoneById == null ? "찾을 수 없음" : phoneById));
  }
}
