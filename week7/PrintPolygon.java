public class PrintPolygon {
  public static void main(String [] args) {
    Polygon[] plist;
    plist = new Polygon[4];

    plist[0] = new Circle();
    plist[1] = new Circle(1, 2, 10);
    plist[2] = new Rectangle();
    plist[3] = new Rectangle(3, 4, 10, 20);

    System.out.println("Total number of polygon:" + plist.length);

    for(int i=0; i< plist.length; i++ ) {
      plist[i].disp();
    }
  }
}
