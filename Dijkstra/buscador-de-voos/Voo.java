public class Voo {
    private String destino;
    private int custo;
    private int duracao; // em minutos

    public Voo(String destino, int custo, int duracao) {
        this.destino = destino;
        this.custo = custo;
        this.duracao = duracao;
    }

    public String getDestino() {
        return destino;
    }
    public int getCusto() {
        return custo;
    }
    public int getDuracao() {
        return duracao;
    }
}
