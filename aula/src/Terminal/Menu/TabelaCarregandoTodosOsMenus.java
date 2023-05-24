package Terminal.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Terminal.Menu.TodosMenus.CadastrarCursoNoAlunoEscolhido;
import Terminal.Menu.TodosMenus.CadastroDeAlunos;
import Terminal.Menu.TodosMenus.CadastroDeMaterias;
import Terminal.Menu.TodosMenus.EditorAluno;
import Terminal.Menu.TodosMenus.GeradorCSV;
import Terminal.Menu.TodosMenus.InformacoesDoAluno;
import Terminal.Menu.TodosMenus.ListarAlunos;
import Terminal.Menu.TodosMenus.ListarMaterias;
import Terminal.Menu.TodosMenus.ListarMateriasPeloAnoX;
import Terminal.Menu.TodosMenus.ProcuraPorAnoPeloCursoSelecionado;

public class TabelaCarregandoTodosOsMenus {
	private Map<Integer, Menus> lista = new HashMap<>();
	

	public TabelaCarregandoTodosOsMenus(Scanner scan) {
		lista.put(1, new CadastroDeAlunos(scan, 1));
		lista.put(2, new ListarAlunos(scan, 2));
		lista.put(3, new CadastroDeMaterias(scan, 3));
		lista.put(4, new ListarMaterias(scan, 4));
		lista.put(5, new ListarMateriasPeloAnoX(scan, 5));
		lista.put(6, new InformacoesDoAluno(scan, 6));
		lista.put(7, new EditorAluno(scan, 7));
		lista.put(8, new CadastrarCursoNoAlunoEscolhido(scan, 8));
		lista.put(9, new GeradorCSV(scan));
		lista.put(10, new ProcuraPorAnoPeloCursoSelecionado(scan,10));
		
	}

	public Map<Integer, Menus> getLista() {
		return lista;
	}
	
}
