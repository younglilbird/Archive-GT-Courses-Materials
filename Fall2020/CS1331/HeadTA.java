public class HeadTA {
    public static void main(String[] args) {
        StoneType[] myStone = new StoneType[4];
        myStone[0] = StoneType.SHINY;
        myStone[1] = StoneType.SMALL;
        myStone[2] = StoneType.BIG;
        myStone[3] = StoneType.GRADING;
        HeadTA.giveCollabStatement(myStone, 3, 4);
        StoneType[] nostones = new StoneType[0];
        HeadTA.giveCollabStatement(nostones, 5, 5);
    }
    public static void giveCollabStatement(StoneType[] stones, int rows, int cols) {
        boolean check = false;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] == StoneType.GRADING) {
                check = true;
            }
        }
        if (check) {
            System.out.println("Snaps Fingers");
            boolean[][] collabStatementArray = new boolean[rows][cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (cols % 2 == 1) {
                        if (r % 2 == 0) {
                            if (c % 2 == 1) {
                                collabStatementArray[r][c] = true;
                            }
                        } else if (r % 2 == 1) {
                            if (c % 2 == 0) {
                                collabStatementArray[r][c] = true;
                            }
                        }
                    } else if (cols % 2 == 0) {
                        if (c % 2 == 1) {
                            collabStatementArray[r][c] = true;
                        }
                    }
                }
            }
            for (int i = 0; i < collabStatementArray.length; i++) {
                for (int j = 0; j < collabStatementArray[i].length; j++) {
                    if (j == collabStatementArray[i].length - 1) {
                        if (collabStatementArray[i][j]) {
                            System.out.println('T');
                        } else {
                            System.out.println('F');
                        }
                    } else {
                        if (collabStatementArray[i][j]) {
                            System.out.print('T');
                        } else {
                            System.out.print('F');
                        }
                    }
                }
            }
        } else {
            System.out.println("Cannot Grade");
        }
    }
}