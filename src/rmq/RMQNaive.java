package rmq;

/**
 * Created by brajesh.k on 04/03/16.
 */
public class RMQNaive extends AbsRMQBase {
    int[][] M;

    public RMQNaive(int[] data) {
        super(data);
        M = new int[N][N];
        preProcess();
    }

    @Override
    public void preProcess() {
        for (int i = 0; i < N; i++) {
            M[i][i] = data[i];
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (data[M[i][j - 1]] < data[j]) {
                    M[i][j] = M[i][j - 1];
                } else {
                    M[i][j] = j;
                }
            }
        }

    }

    @Override
    public int query(int left, int right) {
        return M[left][right];
    }

    public static void main(String[] args) {
        RMQNaive rmq = new RMQNaive(new int[]{2, 4, 3, 1, 6, 7, 8, 9, 1, 7});
        System.out.println(String.format("RMQ(%d, %d) = %d", 2, 7, rmq.query(2, 7)));
        System.out.println(String.format("RMQ(%d, %d) = %d", 5, 9, rmq.query(5, 9)));
    }
}
