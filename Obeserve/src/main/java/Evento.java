import java.util.Observable;

public class Evento extends Observable {

    private String nome;
    private String descricao;
    private String local;

    public Evento(String nome, String descricao, String local) {
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
    }

    public void notificarInscritos() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", local='" + local + '\'' +
                '}';
    }
}