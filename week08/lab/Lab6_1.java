public class Lab6_1 {
  public static void main(String[] args) {
    CanIntro i1, i2;
    HauStudent s = new HauStudent("GongBoo", "Han");
    HauLecture l = new HauLecture("Gildong", "Hong");

    i1 = s;
    i2 = l;

    System.out.println("Alphabetical order based on Last Name");
    if (i1.compareTo(i2) <= 0) {
      i1.introduce();
      i2.introduce();
    } else {
      i2.introduce();
      i1.introduce();
    }
  }
}

class HauLecture extends CanIntro {
  public HauLecture (String first, String last) {
    super(first, last);
  }
  
  public void introduce() {
    System.out.println("I am Prof. " + lastName);
  }
}

class HauStudent extends CanIntro {
  public HauStudent (String first, String last) {
    super(first, last);
  }
  
  public void introduce() {
    System.out.println("I am " + firstName + " " + lastName);
  }
}

abstract class CanIntro implements Comparable<CanIntro> {
  protected String firstName;
  protected String lastName;

  public CanIntro(String first, String last) {
    this.firstName = first;
    this.lastName = last;
  }

  public abstract void introduce();

  public int compareTo(CanIntro other) {
    return this.lastName.compareTo(other.lastName);
  }
}
