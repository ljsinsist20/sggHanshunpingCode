package 稀疏数组与队列.稀疏数组;

/**
 * @author ：ljs
 * @date ：Created in 2022/3/14 21:27
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] chessArr1 = new int[11][11];
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        System.out.println("原始的二维数组~~");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //1.找到数组中非0的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        //2.创建对应稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //2.2将二维数组非0数存入稀疏数组
        int count = 0;//第几个非0数
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("得到稀疏数组为~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0],sparseArr[i][1], sparseArr[i][2]);
        }

        //稀疏恢复原数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("恢复后的二维数组");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
