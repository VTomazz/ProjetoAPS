package Terminal.Menu;

import java.util.HashMap;
import java.util.Map;

import Terminal.Menu.Rendimentos.Exame;
import Terminal.Menu.Rendimentos.ExcluirCurso;
import Terminal.Menu.Rendimentos.Prova1;
import Terminal.Menu.Rendimentos.Prova2;
import Terminal.Menu.Rendimentos.RendimentosControle;
import Terminal.Menu.Rendimentos.Reposicao;

public class TabelaCarregandoTodosOsRendimentosControle {
	private Map<Integer, RendimentosControle> lista = new HashMap<>();

	public TabelaCarregandoTodosOsRendimentosControle() {
		lista.put(1, new Prova1());
		lista.put(2, new Prova2());
		lista.put(3, new Exame());
		lista.put(4, new Reposicao());
		lista.put(5, new ExcluirCurso());
	}

	public Map<Integer, RendimentosControle> getLista() {
		return lista;
	}
}
