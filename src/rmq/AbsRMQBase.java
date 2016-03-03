package rmq;

/**
 * Created by brajesh.k on 04/03/16.
 */
public abstract class AbsRMQBase {
    int N;
    int[] data;

    public AbsRMQBase(int[] data) {
        this.data = data;
        N = data.length;
    }

    public abstract void preProcess();

    public abstract int query(int left, int right);
}
