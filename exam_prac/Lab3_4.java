class Animal {
  private static int animalCount = 0;
  
  public Animal() {
    animalCount++;
  }

  public void animalSound() {
    System.out.println("The animal makes a sound");
  }

  public static int getCount() {return animalCount;}
}

class Dog extends Animal {
  private static int dogCount = 0;
  private int id;
  public Dog() {
    super();
    dogCount++;
    this.id = dogCount;
  }
  
  public void animalSound() {
    System.out.println("The dog" + id + " says : bow wow");
  }

  public static int getCount() {return dogCount;}
}


class Pig extends Animal {
  private static int pigCount = 0;
  private int id;
  public Pig() {
    super();
    pigCount++;
    this.id = pigCount;
  }
  
  public void animalSound() {
    System.out.println("The pig" + id + " says : wee wee");
  }

  public static int getCount() {return pigCount;}
}

public class Lab3_4 {
  public static void main(String[] args) {
    Animal myAnimal = new Animal();
    Animal myPig1 = new Pig();
    Animal myDog1 = new Dog();
    Animal myPig2 = new Pig();
    Animal myDog2 = new Dog();


    myAnimal.animalSound();
    myPig1.animalSound();
    myDog1.animalSound();
    myPig2.animalSound();
    myDog2.animalSound();


    System.out.println("The total number of animals:" + Animal.getCount());
    System.out.println("The total number of dogs:" + Dog.getCount());
    System.out.println("The total number of pigs:" + Pig.getCount());
  }
}
