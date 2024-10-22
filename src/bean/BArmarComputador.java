package bean;

public class BArmarComputador {

    private BChasis chasis;
    private BDiscoDuro dd;
    private int idArmarComputardor;

    public BArmarComputador() {
        this.chasis = new BChasis();
        this.dd = new BDiscoDuro();
    }

    public BArmarComputador(BChasis chasis, BDiscoDuro dd, int id) {
        this.idArmarComputardor = id;
        this.chasis = chasis;
        this.dd = dd;
    }

    public BChasis getChasis() {
        return chasis;
    }

    public void setChasis(BChasis chasis) {
        this.chasis = chasis;
    }

    public BDiscoDuro getDd() {
        return dd;
    }

    public void setDd(BDiscoDuro dd) {
        this.dd = dd;
    }

    public int getIdArmarComputardor() {
        return idArmarComputardor;
    }

    public void setIdArmarComputardor(int idArmarComputardor) {
        this.idArmarComputardor = idArmarComputardor;
    }
}
