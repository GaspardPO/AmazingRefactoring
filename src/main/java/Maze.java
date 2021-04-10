import java.util.Random;

public class Maze {
    public static final int END_LOOP = 1200;

    private static final int DEUX = 2; // ????
    public static final int TROIS = 3; //
    public static final int UN = 1;
    public static final int GOTO_START = 270;

    private final int horizontal;
    private final int vertical;

    int[][] matrixChemin;
    CellType[][] matrix;
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

        this.matrixChemin = new int[horizontal + 1][vertical + 1];
        for (int i = 0; i <= horizontal; i++) {
            matrixChemin[i] = new int[vertical + 1];
        }

        this.matrix = new CellType[horizontal + 1][vertical + 1];
        for (int i = 0; i <= horizontal; i++) {
            matrix[i] = new CellType[vertical + 1];
            for (int j = 0; j <= vertical; j++) {
                matrix[i][j] = CellType.CLOSE_RIGHT_BOTTOM;
            }
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

        print(":");
        println();


        int c = 1;
        matrixChemin[rowChemin][1] = c;
        c++;


        int row = rowChemin;
        int line = 1;
        GOTO(GOTO_START);

        while (target != -1) {
            switch (target) {
                case 210:
                    if (row != horizontal) {
                        row++;
                    } else {
                        if (line != vertical) {
                            row = 1;
                            line++;
                        } else {
                            row = 1;
                            line = 1;
                        }
                    }
                    GOTO(260);
                    continue;
                case 260:
                    if (isNotChemin(row, line))
                        GOTO(210);
                    else
                        GOTO(GOTO_START);
                    continue;
                case GOTO_START: //start
                    q = 0;
                    if (row - 1 == 0)
                        GOTO(600);
                    else
                        GOTO(280);
                    continue;
                case 280:
                    if (isChemin(row - 1, line))
                        GOTO(600);
                    else {
                        if (line - 1 == 0)
                            GOTO(430);
                        else {
                            if (isChemin(row, line - 1))
                                GOTO(430);
                            else {
                                if (row == horizontal)
                                    GOTO(350);
                                else {
                                    if (isChemin(row + 1, line))
                                        GOTO(350);
                                    else {
                                        rowChemin = rand(3);
                                        GOTO(340);
                                    }
                                }
                            }
                        }
                    }
                    continue;
                case 340:
                    if (rowChemin == UN)
                        GOTO(940);
                    else if (rowChemin == DEUX)
                        GOTO(980);
                    else if (rowChemin == TROIS)
                        GOTO(1020);
                    else
                        GOTO(350);
                    continue;
                case 350:
                    if (line != vertical) {
                        if (isChemin(row, line + 1))
                            GOTO(410);
                        else
                            GOTO(390);
                    } else
                        GOTO(360);
                    continue;
                case 360:
                    if (z == 1)
                        GOTO(410);
                    else {
                        q = 1;
                        GOTO(390);
                    }
                    continue;
                case 390:
                    rowChemin = rand(3);
                    if (rowChemin == UN)
                        GOTO(940);
                    else if (rowChemin == DEUX)
                        GOTO(980);
                    else if (rowChemin == TROIS)
                        GOTO(1090);
                    else
                        GOTO(410);
                    continue;
                case 410:
                    rowChemin = rand(2);
                    if (rowChemin == UN)
                        GOTO(940);
                    else if (rowChemin == DEUX)
                        GOTO(980);
                    else
                        GOTO(430);
                    continue;
                case 430:
                    if (row == horizontal)
                        GOTO(530);
                    else {
                        if (isChemin(row + 1, line))
                            GOTO(530);
                        else {
                            if (line != vertical)
                                GOTO(480);
                            else
                                GOTO(460);
                        }
                    }
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
                    if (isChemin(row, line + 1))
                        GOTO(510);
                    else
                        GOTO(490);
                    continue;
                case 490:
                    rowChemin = rand(3);
                    GOTO(500);
                    continue;
                case 500:
                    if (rowChemin == UN)
                        GOTO(940);
                    else if (rowChemin == DEUX)
                        GOTO(1020);
                    else if (rowChemin == TROIS)
                        GOTO(1090);
                    else
                        GOTO(510);
                    continue;
                case 510:
                    rowChemin = rand(2);
                    GOTO(520);
                    continue;
                case 520:
                    if (rowChemin == UN)
                        GOTO(940);
                    else if (rowChemin == DEUX)
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
                    if (isChemin(row, line + 1))
                        GOTO(590);
                    else
                        GOTO(570);
                    continue;
                case 570:
                    rowChemin = rand(2);
                    GOTO(580);
                    continue;
                case 580:
                    if (rowChemin == UN)
                        GOTO(940);
                    else if (rowChemin == DEUX)
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
                    if (isChemin(row, line - 1))
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
                    if (isChemin(row + 1, line))
                        GOTO(720);
                    else
                        GOTO(640);
                    continue;
                case 640:
                    if (line != vertical) {
                        if (isChemin(row, line + 1))
                            GOTO(700);
                        else
                            GOTO(680);
                    }
                    else {
                        if (z == 1)
                            GOTO(700);
                        else {
                            q = 1;
                            GOTO(680);
                        }
                    }
                    continue;
                case 680:
                    rowChemin = rand(3);
                    if (rowChemin == UN)
                        GOTO(980);
                    else if (rowChemin == DEUX)
                        GOTO(1020);
                    else if (rowChemin == TROIS)
                        GOTO(1090);
                    continue;
                case 700:
                    rowChemin = rand(2);
                    if (rowChemin == UN)
                        GOTO(980);
                    else if (rowChemin == DEUX)
                        GOTO(1020);
                    continue;
                case 720:
                    if (line != vertical) {
                        if (isChemin(row, line + 1))
                            GOTO(980);
                        else
                            GOTO(760);
                    }
                    else {
                        if (z == 1)
                            GOTO(980);
                        else {
                            q = 1;
                            GOTO(760);
                        }
                    }
                    continue;
                case 760:
                    rowChemin = rand(2);
                    if (rowChemin == UN)
                        GOTO(980);
                    else if (rowChemin == DEUX)
                        GOTO(1090);
                    continue;
                case 790:
                    if (row == horizontal)
                        GOTO(880);
                    else
                        GOTO(800);
                    continue;
                case 800:
                    if (isChemin(row + 1, line))
                        GOTO(880);
                    else {
                        if (line != vertical) {
                            if (isChemin(row, line + 1))
                                GOTO(1020);
                            else {
                                rowChemin = rand(2);
                                if (rowChemin == UN)
                                    GOTO(1020);
                                else if (rowChemin == DEUX)
                                    GOTO(1090);
                            }
                        } else {
                            if (z == 1)
                                GOTO(1020);
                            else {
                                q = 1;
                                GOTO(990);
                            }
                        }
                    }
                    continue;
                case 880:
                    if (line != vertical) {
                        if (isChemin(row, line + 1))
                            GOTO(210);
                        else
                            GOTO(1090);
                    } else {
                        if (z == 1)
                            GOTO(210);
                        else {
                            q = 1;
                            GOTO(1090);
                        }
                    }
                    continue;
                case 940:
                    matrixChemin[row - 1][line] = c;
                    c++;
                    matrix[row - 1][line] = CellType.CLOSE_BOTTOM;
                    row--;
                    if (mazeIsFinished(horizontal, vertical, c))
                        GOTO(END_LOOP);
                    else {
                        GOTO(GOTO_START);
                    }
                    continue;
                case 980:
                    matrixChemin[row][line - 1] = c;
                    GOTO(990);
                    continue;
                case 990:
                    c++;
                    matrix[row][line - 1] = CellType.CLOSE_RIGHT;
                    line--;
                    if (mazeIsFinished(horizontal, vertical, c))
                        GOTO(END_LOOP);
                    else {
                        GOTO(GOTO_START);
                    }
                    continue;
                case 1020:
                    matrixChemin[row + 1][line] = c;
                    c++;
                    if (matrix[row][line] == CellType.CLOSE_RIGHT_BOTTOM)
                        matrix[row][line] = CellType.CLOSE_BOTTOM;
                    else
                        matrix[row][line] = CellType.OPEN;
                    row++;
                    if (mazeIsFinished(horizontal, vertical, c))
                        GOTO(END_LOOP);
                    else
                        GOTO(600);
                    continue;
                case 1090:
                    if (q == 1) {
                        z = 1;
                        if (matrix[row][line] == CellType.CLOSE_RIGHT_BOTTOM) {
                            matrix[row][line] = CellType.CLOSE_RIGHT;
                            q = 0;
                            row = 1;
                            line = 1;
                            GOTO(260);
                        } else {
                            matrix[row][line] = CellType.OPEN;
                            q = 0;
                            GOTO(210);
                        }
                    } else {
                        matrixChemin[row][line + 1] = c;
                        c++;
                        if (matrix[row][line] == CellType.CLOSE_RIGHT_BOTTOM) {
                            matrix[row][line] = CellType.CLOSE_RIGHT;
                        } else {
                            matrix[row][line] = CellType.OPEN;
                        }
                        line++;
                        if (mazeIsFinished(vertical, horizontal, c))
                            GOTO(END_LOOP);
                        else
                            GOTO(GOTO_START);
                    }
                    continue;
                case END_LOOP: // FIN
                    target = -1;
            }

        }

        // 1200:
        for (int j = 1; j <= vertical; j++) {
            print("I");        // 1210

            for (int i = 1; i <= horizontal; i++) {
                if (matrix[i][j] == CellType.CLOSE_RIGHT_BOTTOM || matrix[i][j] == CellType.CLOSE_RIGHT) {
                    print("  I");
                } else if (matrix[i][j] == CellType.CLOSE_BOTTOM || matrix[i][j] == CellType.OPEN) {
                    print("   ");
                }
            }

            print(" ");   // 1280
            println();

            for (int i = 1; i <= horizontal; i++) {
                if (matrix[i][j] == CellType.CLOSE_RIGHT_BOTTOM)
                    print(":--");
                else if (matrix[i][j] == CellType.CLOSE_BOTTOM)
                    print(":--");
                else if (matrix[i][j] == CellType.CLOSE_RIGHT || matrix[i][j] == CellType.OPEN)
                    print(":  ");
            }

            print(":");    // 1360
            println();
        }
    }


    private boolean isNotChemin(int row, int line) {
        return !isChemin(row, line);
    }

    private boolean isChemin(int row, int line) {
        return matrixChemin[row][line] != 0;
    }

    private boolean mazeIsFinished(int horizontal, int vertical, int c) {
        return c == horizontal * vertical + 1;
    }
}
