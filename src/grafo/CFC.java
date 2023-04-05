package grafo;

import java.util.ArrayList;
import java.util.List;

public class CFC<E> {
    private List<VerticeForte<E>> cluster;

    public CFC() {
        cluster = new ArrayList<>();
    }

    public List<VerticeForte<E>> getCluster() {
        return cluster;
    }

    public void setCluster(List<VerticeForte<E>> cluster) {
        this.cluster = cluster;
    }
}
