public class Main {
    public static void main(String[] args) {
        int nDisks = 4;
        doTowers(nDisks, 'A', 'B', 'C');
    }
    public static void doTowers(int topN, char colA,
                                char colB, char colC) {
        if (topN == 1){
            System.out.println("Disk 1 from "
                    + colA + " to " + colC);
        }else {
            doTowers(topN - 1, colA, colC, colB);
            System.out.println("Disk "
                    + topN + " from " + colA + " to " + colC);
            doTowers(topN - 1, colB, colA, colC);
        }
    }
}
