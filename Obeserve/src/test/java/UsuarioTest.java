import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void deveNotificarUmUsuario() {
        Evento evento = new Evento("Conferência", "Conferência sobre inteligência artificial", "Centro de Convenções");
        Usuario usuario = new Usuario("BRENO");
        usuario.seInscrever(evento);
        evento.notificarInscritos();
        assertEquals("BRENO, novo evento disponível: Evento{nome='Conferência', descricao='Conferência sobre inteligência artificial', local='Centro de Convenções'}", usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarios() {
        Evento evento = new Evento("Conferência", "Conferência sobre lol", "Casa");
        Usuario usuario1 = new Usuario("Breno");
        Usuario usuario2 = new Usuario("Leo");
        Usuario usuario3 = new Usuario("Arthur");
        usuario1.seInscrever(evento);
        usuario2.seInscrever(evento);
        usuario3.seInscrever(evento);
        evento.notificarInscritos();
        assertEquals("Breno, novo evento disponível: Evento{nome='Conferência', descricao='Conferência sobre lol', local='Casa'}", usuario1.getUltimaNotificacao());
        assertEquals("Leo, novo evento disponível: Evento{nome='Conferência', descricao='Conferência sobre lol', local='Casa'}", usuario2.getUltimaNotificacao());
        assertEquals("Arthur, novo evento disponível: Evento{nome='Conferência', descricao='Conferência sobre lol', local='Casa'}", usuario3.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarUsuario() {
        Evento evento = new Evento("Conferência", "Barbosa chamando para jogar", "Casa");
        Usuario usuario = new Usuario("Breno");
        evento.notificarInscritos();
        assertEquals(null, usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarioEventoA() {
        Evento eventoA = new Evento("Conferência", "Conferência sobre inteligência artificial", "Centro de Convenções A");
        Evento eventoB = new Evento("Workshop", "Workshop de programação", "Centro de Convenções B");
        Usuario usuario1 = new Usuario("BRENO");
        Usuario usuario2 = new Usuario("ARTHUR");
        usuario1.seInscrever(eventoA);
        usuario2.seInscrever(eventoB);
        eventoA.notificarInscritos();
        assertEquals("BRENO, novo evento disponível: Evento{nome='Conferência', descricao='Conferência sobre inteligência artificial', local='Centro de Convenções A'}", usuario1.getUltimaNotificacao());
        assertEquals(null, usuario2.getUltimaNotificacao());
    }
}