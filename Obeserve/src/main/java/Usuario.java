import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void seInscrever(Evento evento) {
        evento.addObserver(this);
    }

    public void update(Observable evento, Object arg1) {
        this.ultimaNotificacao = this.nome + ", novo evento disponível: " + evento.toString();
        // System.out.println(this.ultimaNotificacao);
    }
}