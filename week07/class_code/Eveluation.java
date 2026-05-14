import java.util.*;

public class Eveluation {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("팀의 갯수를 적어주세요. >>>");
    int teamNum = scan.nextInt();
    int[][] teamArr = new int[teamNum][5];
    int[] teamSum = new int[teamNum];

    for(int i = 0; i < teamNum; i++) {
      System.out.print("팀" + (i+1) + "의 점수를 입력해주세요. (ex: 40 30 20 10 32) >>>");
      for(int j = 0; j < 5; j++) {
        teamArr[i][j] = scan.nextInt();
        teamSum[i] += teamArr[i][j];
      }
    }

    for(int i = 0; i < teamNum; i++) {
      System.out.print("팀" + (i+1) + "의 점수는");
      for(int j = 0; j < 4; j++) {
        System.out.print(teamArr[i][j] + ", ");
      }
      System.out.println(teamArr[i][4] + "입니다. 총합 " + teamSum[i] + "입니다.");
    }
    scan.close();
  }
}
