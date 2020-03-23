import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        int[][] bingoCard = new int[5][5];

        fillArray(random, bingoCard);

        System.out.printf("%3s", "B");
        System.out.printf("%3s", "I");
        System.out.printf("%3s", "N");
        System.out.printf("%3s", "G");
        System.out.printf("%4s", "O\n");
        System.out.printf("________________\n");
        cardMaker(bingoCard);
        System.out.printf("----------------");
    }

    private static void fillArray(Random random, int[][] bingoCard) {
        for (int r = 0; r < bingoCard.length; r++) {
            for (int k = 0; k < bingoCard.length; k++) {
                int tmp = random.nextInt(16);
                while (tmp == 0) {
                    tmp = random.nextInt(16);
                }
                tmp += r * 15;

                //check for doubles
                while (tmp == bingoCard[r][0] || tmp == bingoCard[r][1] || tmp == bingoCard[r][2] || tmp == bingoCard[r][3] || tmp == bingoCard[r][4]) {
                    tmp = random.nextInt(16);
                    tmp += r * 15;
                }
                bingoCard[r][k] = tmp;
            }
        }
    }

    private static void cardMaker(int[][] bingoCard) {
        for (int r = 0; r < 5; r++) {
            for (int k = 0; k < 5; k++) {
                if (r == 2 && k == 2) {
                    System.out.printf("|" + "%2s", "FS");

                } else {
                    System.out.printf("|" + "%2d", bingoCard[k][r]);
                }
            }
            System.out.println("|");
        }
    }

}