class NDice {
  private int faces;
  private int currentFace;


}

public class playground {
  public main static void(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.print("주사위 면수 입력 ㄱㄱ");
    int n = scanner.nextInt();

    NDice dice1 = new NDice(n);
    NDice dice2 = new NDice(n);

    Stytem.out.print("주사위 ㄱㄱ?(Y/N)");
    String response = scanner.next();

    if (response.equlsIgnoreCase("Y")) {
      dice1.roll();
      dice2.roll();


    }

    scanner.close();
  }

