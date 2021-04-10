import java.util.Random;

public class Maze {
    public static final int END_LOOP = 1200;
    public static final int CLOSE_RIGHT_OPEN_BOTTOM = 1;

    private final int horizontal;
    private final int vertical;

    int[][] wArray;
    int[][] matrix;
    int target = 0;      // where GOTO goes
    int q = 0;
    int z = 0;
    int rowChemin;
    Random random;


    StringBuffer result = new StringBuffer();

    private void println() {
        result.append("\n");
    }

    public void print(String text) {
        result.append(text);
    }

    public Maze(int horizontal, int vertical, Random random) {
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.random = random;

        this.wArray = new int[horizontal + 1][vertical + 1];
        for (int i = 0; i <= horizontal; i++) {
            wArray[i] = new int[vertical + 1];
        }

        this.matrix = new int[horizontal + 1][vertical + 1];
        for (int i = 0; i <= horizontal; i++) {
            matrix[i] = new int[vertical + 1];
        }
    }

    public void GOTO(int lineno) {
        target = lineno;
    }


    public int rand(int count) {
        return (int) (count * random.nextFloat()) + 1;
    }

    public void extracted() {
        print("Amazing - Copyright by Creative Computing, Morristown, NJ");
        println();

        if (horizontal == 1 || vertical == 1) return;
        this.rowChemin = rand(horizontal);

        // 130:170 // crée la 1ere ligne ?
        for (int i = 1; i <= horizontal; i++) {
            if (i == rowChemin)
                print(":  ");
            else
                print(":--");
        }
        // 180
        print(":");
        println();

        // 190
        int c = 1;
        wArray[rowChemin][1] = c;
        c++;

        // 200
        int row = rowChemin;
        int line = 1;
        GOTO(270);

        while (target != -1) {
            switch (target) {
                case 210:
                    if (row != horizontal)
                        GOTO(250);
                    else
                        GOTO(220);
                    continue;
                case 220:
                    if (line != vertical)
                        GOTO(240);
                    else
                        GOTO(230);
                    continue;
                case 230:
                    row = 1;
                    line = 1;
                    GOTO(260);
                    continue;
                case 240:
                    row = 1;
                    line++;
                    GOTO(260);
                    continue;
                case 250:
                    row++;
                    GOTO(260);
                    continue;
                case 260:
                    if (wArray[row][line] == 0)
                        GOTO(210);
                    else
                        GOTO(270);
                    continue;
                case 270: //start
                    if (row - 1 == 0)
                        GOTO(600);
                    else
                        GOTO(280);
                    continue;
                case 280:
                    if (wArray[row - 1][line] != 0)
                        GOTO(600);
                    else
                        GOTO(290);
                    continue;
                case 290:
                    if (line - 1 == 0)
                        GOTO(430);
                    else
                        GOTO(300);
                    continue;
                case 300:
                    if (wArray[row][line - 1] != 0)
                        GOTO(430);
                    else
                        GOTO(310);
                    continue;
                case 310:
                    if (row == horizontal)
                        GOTO(350);
                    else
                        GOTO(320);
                    continue;
                case 320:
                    if (wArray[row + 1][line] != 0)
                        GOTO(350);
                    else
                        GOTO(330);
                    continue;
                case 330:
                    rowChemin = rand(3);
                    GOTO(340);
                    continue;
                case 340:
                    if (rowChemin == 1)
                        GOTO(940);
                    else if (rowChemin == 2)
                        GOTO(980);
                    else if (rowChemin == 3)
                        GOTO(1020);
                    else
                        GOTO(350);
                    continue;
                case 350:
                    if (line != vertical)
                        GOTO(380);
                    else
                        GOTO(360);
                    continue;
                case 360:
                    if (z == 1)
                        GOTO(410);
                    else
                        GOTO(370);
                    continue;
                case 370:
                    q = 1;
                    GOTO(390);
                    continue;
                case 380:
                    if (wArray[row][line + 1] != 0)
                        GOTO(410);
                    else
                        GOTO(390);
                    continue;
                case 390:
                    rowChemin = rand(3);
                    GOTO(400);
                    continue;
                case 400:
                    if (rowChemin == 1)
                        GOTO(940);
                    else if (rowChemin == 2)
                        GOTO(980);
                    else if (rowChemin == 3)
                        GOTO(1090);
                    else
                        GOTO(410);
                    continue;
                case 410:
                    rowChemin = rand(2);
                    GOTO(420);
                    continue;
                case 420:
                    if (rowChemin == 1)
                        GOTO(940);
                    else if (rowChemin == 2)
                        GOTO(980);
                    else
                        GOTO(430);
                    continue;
                case 430:
                    if (row == horizontal)
                        GOTO(530);
                    else
                        GOTO(440);
                    continue;
                case 440:
                    if (wArray[row + 1][line] != 0)
                        GOTO(530);
                    else
                        GOTO(450);
                    continue;
                case 450:
                    if (line != vertical)
                        GOTO(480);
                    else
                        GOTO(460);
                    continue;
                case 460:
                    if (z == 1)
                        GOTO(510);
                    else
                        GOTO(470);
                    continue;
                case 470:
                    q = 1;
                    GOTO(490);
                    continue;
                case 480:
                    if (wArray[row][line + 1] != 0)
                        GOTO(510);
                    else
                        GOTO(490);
                    continue;
                case 490:
                    rowChemin = rand(3);
                    GOTO(500);
                    continue;
                case 500:
                    if (rowChemin == 1)
                        GOTO(940);
                    else if (rowChemin == 2)
                        GOTO(1020);
                    else if (rowChemin == 3)
                        GOTO(1090);
                    else
                        GOTO(510);
                    continue;
                case 510:
                    rowChemin = rand(2);
                    GOTO(520);
                    continue;
                case 520:
                    if (rowChemin == 1)
                        GOTO(940);
                    else if (rowChemin == 2)
                        GOTO(1020);
                    else
                        GOTO(530);
                    continue;
                case 530:
                    if (line != vertical)
                        GOTO(560);
                    else
                        GOTO(540);
                    continue;
                case 540:
                    if (z == 1)
                        GOTO(590);
                    else
                        GOTO(550);
                    continue;
                case 550:
                    q = 1;
                    GOTO(570);
                    continue;
                case 560:
                    if (wArray[row][line + 1] != 0)
                        GOTO(590);
                    else
                        GOTO(570);
                    continue;
                case 570:
                    rowChemin = rand(2);
                    GOTO(580);
                    continue;
                case 580:
                    if (rowChemin == 1)
                        GOTO(940);
                    else if (rowChemin == 2)
                        GOTO(1090);
                    else
                        GOTO(590);
                    continue;
                case 590:
                    GOTO(940);
                    continue;
                case 600:
                    if (line - 1 == 0)
                        GOTO(790);
                    else
                        GOTO(610);
                    continue;
                case 610:
                    if (wArray[row][line - 1] != 0)
                        GOTO(790);
                    else
                        GOTO(620);
                    continue;
                case 620:
                    if (row == horizontal)
                        GOTO(720);
                    else
                        GOTO(630);
                    continue;
                case 630:
                    if (wArray[row + 1][line] != 0)
                        GOTO(720);
                    else
                        GOTO(640);
                    continue;
                case 640:
                    if (line != vertical)
                        GOTO(670);
                    else
                        GOTO(650);
                    continue;
                case 650:
                    if (z == 1)
                        GOTO(700);
                    else
                        GOTO(660);
                    continue;
                case 660:
                    q = 1;
                    GOTO(680);
                    continue;
                case 670:
                    if (wArray[row][line + 1] != 0)
                        GOTO(700);
                    else
                        GOTO(680);
                    continue;
                case 680:
                    rowChemin = rand(3);
                    GOTO(690);
                    continue;
                case 690:
                    if (rowChemin == 1)
                        GOTO(980);
                    else if (rowChemin == 2)
                        GOTO(1020);
                    else if (rowChemin == 3)
                        GOTO(1090);
                    else
                        GOTO(700);
                    continue;
                case 700:
                    rowChemin = rand(2);
                    GOTO(710);
                    continue;
                case 710:
                    if (rowChemin == 1)
                        GOTO(980);
                    else if (rowChemin == 2)
                        GOTO(1020);
                    else
                        GOTO(720);
                    continue;
                case 720:
                    if (line != vertical)
                        GOTO(750);
                    else
                        GOTO(730);
                    continue;
                case 730:
                    if (z == 1)
                        GOTO(780);
                    else
                        GOTO(740);
                    continue;
                case 740:
                    q = 1;
                    GOTO(760);
                    continue;
                case 750:
                    if (wArray[row][line + 1] != 0)
                        GOTO(780);
                    else
                        GOTO(760);
                    continue;
                case 760:
                    rowChemin = rand(2);
                    GOTO(770);
                    continue;
                case 770:
                    if (rowChemin == 1)
                        GOTO(980);
                    else if (rowChemin == 2)
                        GOTO(1090);
                    else
                        GOTO(780);
                    continue;
                case 780:
                    GOTO(980);
                    continue;
                case 790:
                    if (row == horizontal)
                        GOTO(880);
                    else
                        GOTO(800);
                    continue;
                case 800:
                    if (wArray[row + 1][line] != 0)
                        GOTO(880);
                    else
                        GOTO(810);
                    continue;
                case 810:
                    if (line != vertical)
                        GOTO(840);
                    else
                        GOTO(820);
                    continue;
                case 820:
                    if (z == 1)
                        GOTO(870);
                    else
                        GOTO(830);
                    continue;
                case 830:
                    q = 1;
                    GOTO(990);
                    continue;
                case 840:
                    if (wArray[row][line + 1] != 0)
                        GOTO(870);
                    else
                        GOTO(850);
                    continue;
                case 850:
                    rowChemin = rand(2);
                    GOTO(860);
                    continue;
                case 860:
                    if (rowChemin == 1)
                        GOTO(1020);
                    else if (rowChemin == 2)
                        GOTO(1090);
                    else
                        GOTO(870);
                    continue;
                case 870:
                    GOTO(1020);
                    continue;
                case 880:
                    if (line != vertical)
                        GOTO(910);
                    else
                        GOTO(890);
                    continue;
                case 890:
                    if (z == 1)
                        GOTO(930);
                    else
                        GOTO(900);
                    continue;
                case 900:
                    q = 1;
                    GOTO(920);
                    continue;
                case 910:
                    if (wArray[row][line + 1] != 0)
                        GOTO(930);
                    else
                        GOTO(920);
                    continue;
                case 920:
                    GOTO(1090);
                    continue;
                case 930:
                    GOTO(1190);
                    continue;
                case 940:
                    wArray[row - 1][line] = c;
                    GOTO(950);
                    continue;
                case 950:
                    c++;
                    matrix[row - 1][line] = 2;
                    row--;
                    GOTO(960);
                    continue;
                case 960:
                    if (mazeIsFinished(horizontal, vertical, c))
                        GOTO(END_LOOP);
                    else
                        GOTO(970);
                    continue;
                case 970:
                case 1010:
                    q = 0;
                    GOTO(270);
                    continue;
                case 980:
                    wArray[row][line - 1] = c;
                    GOTO(990);
                    continue;
                case 990:
                    c++;
                    GOTO(1000);
                    continue;
                case 1000:
                    closeRightOpenBottom(row, line - 1);
                    line--;
                    if (mazeIsFinished(horizontal, vertical, c))
                        GOTO(END_LOOP);
                    else
                        GOTO(1010);
                    continue;
                case 1020:
                    wArray[row + 1][line] = c;
                    GOTO(1030);
                    continue;
                case 1030:
                    c++;
                    if (matrix[row][line] == 0)
                        GOTO(1050);
                    else
                        GOTO(1040);
                    continue;
                case 1040:
                    matrix[row][line] = 3;
                    GOTO(1060);
                    continue;
                case 1050:
                    matrix[row][line] = 2;
                    GOTO(1060);
                    continue;
                case 1060:
                    row++;
                    GOTO(1070);
                    continue;
                case 1070:
                    if (mazeIsFinished(horizontal, vertical, c))
                        GOTO(END_LOOP);
                    else
                        GOTO(1080);
                    continue;
                case 1080:
                    GOTO(600);
                    continue;
                case 1090:
                    if (q == 1)
                        GOTO(1150);
                    else
                        GOTO(1100);
                    continue;
                case 1100:
                    wArray[row][line + 1] = c;
                    c++;
                    if (matrix[row][line] == 0)
                        GOTO(1120);
                    else
                        GOTO(1110);
                    continue;
                case 1110:
                    matrix[row][line] = 3;
                    GOTO(1130);
                    continue;
                case 1120:
                    closeRightOpenBottom(row, line);
                    GOTO(1130);
                    continue;
                case 1130:
                    line++;
                    if (mazeIsFinished(vertical, horizontal, c))
                        GOTO(END_LOOP);
                    else
                        GOTO(1140);
                    continue;
                case 1140:
                    GOTO(270);
                    continue;
                case 1150:
                    z = 1;
                    GOTO(1160);
                    continue;
                case 1160:
                    if (matrix[row][line] == 0)
                        GOTO(1180);
                    else
                        GOTO(1170);
                    continue;
                case 1170:
                    matrix[row][line] = 3;
                    q = 0;
                    GOTO(1190);
                    continue;
                case 1180:
                    closeRightOpenBottom(row, line);
                    q = 0;
                    row = 1;
                    line = 1;
                    GOTO(260);
                    continue;
                case 1190:
                    GOTO(210);
                    continue;
                case END_LOOP: // FIN
                    target = -1;
            }

        }

        // 1200:
        for (int j = 1; j <= vertical; j++) {
            print("I");        // 1210

            /*
            0 :
              I
            :--

            1 :
              I
            :

            2 :

            :--

            3 :


             */

            for (int i = 1; i <= horizontal; i++) {
                if (matrix[i][j] == 0 || matrix[i][j] == CLOSE_RIGHT_OPEN_BOTTOM) {
                    print("  I");
                } else if (matrix[i][j] == 2 || matrix[i][j] == 3) {
                    print("   ");
                }
            }

            print(" ");   // 1280
            println();

            for (int i = 1; i <= horizontal; i++) {
                if (matrix[i][j] == 0)
                    print(":--");
                else if (matrix[i][j] == 2)
                    print(":--");
                else if (matrix[i][j] == 1 || matrix[i][j] == 3)
                    print(":  ");
            }

            print(":");    // 1360
            println();
        }
    }

    private void closeRightOpenBottom(int r, int s) {
        matrix[r][s] = CLOSE_RIGHT_OPEN_BOTTOM;
    }

    private boolean mazeIsFinished(int horizontal, int vertical, int c) {
        return c == horizontal * vertical + 1;
    }
}
