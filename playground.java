public class playground {
  private static double average(String[] args) {
    double sum = 0;
    for (String arg : args) {
      sum += Double.parseDouble(arg);
    }
    return sum / args.length;
  }
  public static void main(String[] args) {
    System.out.println(average(args));
  }
}
