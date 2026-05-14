import java.io.*;

class SaveCar {
  public static void main(String[] args) throws IOException {
    String datafile = args[0];
    Car[] carArray = new Car[3];
    carArray[0] = new Car("Red", "Hyundai");
    carArray[1] = new Car("Black", "Kia");
    carArray[2] = new Car("Silver", "BMW");
    
    try {
      FileWriter fw = new FileWriter(datafile);
      BufferedWriter bw = new BufferedWriter(fw);

      for (Car car : carArray) {
        try {
          bw.write(car.toString());
          bw.newLine();
        } catch (IOException e) {
          System.out.println(e);
        }
      }
      bw.close();
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
