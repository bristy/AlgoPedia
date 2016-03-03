package rmq;

import java.util.Arrays;

/**
 * Created by brajesh.k on 04/03/16.
 */
public class RMQSQRTDecompositon extends AbsRMQBase {
    int len; // total blocks
    int[] sqrtMin;

    public RMQSQRTDecompositon(int[] data) {
        super(data);
        len = (int) (Math.sqrt(N));
        sqrtMin = new int[N / len + 1];
        for (int i = 0; i < N / len + 1; i++) {
            sqrtMin[i] = -1;
        }
        preProcess();
    }

    @Override
    public void preProcess() {
        for (int i = 0; i < N; i++) {
            if (sqrtMin[i / len] == -1 || data[i] < data[sqrtMin[i / len]]) {
                sqrtMin[i / len] = i;
            }
        }


    }

    @Override
    public int query(int left, int right) {
        int cl = left / len;
        int cr = right / len;
        int ret = -1;
        if (cl == cr) {
            for (int i = left; i <= right; i++) {
                if (ret == -1 || data[i] < data[ret]) {
                    ret = i;
                }
            }
            return ret;
        }

        for (int i = left; i < (cl + 1) * len; i++) {
            if (ret == -1 || data[i] < data[ret]) {
                ret = i;
            }
        }

        for (int i = cl + 1; i < cr; i++) {
            if (ret == -1 || data[sqrtMin[i]] < data[ret]) {
                ret = sqrtMin[i];
            }
        }

        for (int i = cr * len; i <= right ; i++) {
            if (ret == -1 || data[i] < data[ret]) {
                ret = i;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 4, 3, 1, 6, 7, 8, 9, 1, 7};
        RMQSQRTDecompositon rmq = new RMQSQRTDecompositon(A);
        System.out.println(Arrays.toString(A));
        System.out.println(String.format("RMQ(%d, %d) = %d", 8, 9, rmq.query(8, 9)));
    }
}
