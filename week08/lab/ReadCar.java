import java.io.*;

class ReadCar {
  public static void main(String[] args) {
    String datafile = args[0];
    
    Car[] carArray = new Car[3];
    
    try {
      FileReader fr = new FileReader(datafile);
      BufferedReader br = new BufferedReader(fr);

      int count = 1;

      for(Car c: carArray) {
        try {
          String line = br.readLine();
          System.out.println("Car " + count++ + ": " + line);
        } catch (IOException e) {
          System.out.println(e);
        }
      }
    } catch (IOException e) {
      System.out.println(e);
    }

  }
}
