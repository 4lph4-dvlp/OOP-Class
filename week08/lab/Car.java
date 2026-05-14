class Car{
  private String color;
  private String brand;

  Car(String color, String brand) {
    this.color = color;
    this.brand = brand;
  }
  
  public String getColor() {
    return color;
  }
  public String getBrand() {
    return brand;
  }

  public String toString() {
    return brand + " " + color;
  }

}
