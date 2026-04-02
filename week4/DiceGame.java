import java.util.Scanner;

class NDice {
    private int faces;
    private int currentFace;

    public NDice(int n) {
        this.faces = n;
        this.currentFace = 1;
    }

    public void roll() {
        this.currentFace = (int) (Math.random() * faces) + 1;
    }

    public int getFace() {
        return currentFace;
    }
}

public class DiceGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("몇 면 주사위를 만드시겠습니까? ");
        int n = scanner.nextInt();

        NDice dice1 = new NDice(n);
        NDice dice2 = new NDice(n);

        System.out.print("주사위를 굴리시겠습니까? (Y/N) ");
        String response = scanner.next();

        if (response.equalsIgnoreCase("Y")) {
            dice1.roll();
            dice2.roll();

            int face1 = dice1.getFace();
            int face2 = dice2.getFace();
            int sum = face1 + face2;

            System.out.println("주사위1 : " + face1);
            System.out.println("주사위2 : " + face2);
            System.out.println("주사위합 : " + sum);
        }

        scanner.close();
    }
}
