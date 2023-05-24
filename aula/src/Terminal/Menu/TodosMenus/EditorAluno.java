package Terminal.Menu.TodosMenus;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Exception.TodasExcecoes;
import Exception.VerificarSeDoubleException;
import Fabricas.FabricaCadastroCursoAluno;
import Fabricas.FabricaDeAluno;
import Terminal.CONTROLEGERAL;
import Terminal.Menu.Menus;
import Terminal.Menu.TabelaCarregandoTodosOsRendimentosControle;
import Verificacoes.EntradaDeLetraInserindoCaracteresEspeciais;
import Verificacoes.EntradaDeNumeroInserindoLetra;
import aula.cadastro.Aluno;
import aula.cadastro.CadastroCursoAluno;

public class EditorAluno extends Menus {

	private FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
	private FabricaCadastroCursoAluno fabricaDeCursoAluno = new FabricaCadastroCursoAluno();

	public EditorAluno(Scanner scan, Integer id) {
		super(scan, id);

	}

	@Override
	public void executar()
			throws TodasExcecoes {

		FabricaDeAluno fabricaAluno = new FabricaDeAluno();
		fabricaAluno.resultadoGeral();
		System.out.println("Digite o ID do Aluno que deseja editar...");
		String id = scan.next();
		try {
			if (new EntradaDeNumeroInserindoLetra().verificar(id)) {

				Aluno aluno = fabricaDeAluno.buscarPorId(id);
				if (aluno != null) {

					System.out.println("Selecione oque você deseja alterar do Aluno " + aluno.getNome());
					System.out.println("[1]Nome | [2]Cursos ");
					String resultado = scan.next();
					if (new EntradaDeNumeroInserindoLetra().verificar(resultado)) {
						scan.nextLine();
						switch (Integer.parseInt(resultado)) {
						case 1:
							System.out.println(
									"O Nome do Aluno esta: " + aluno.getNome() + " para qual nome deseja alterar...");

							String novoNome = scan.nextLine();

							if (new EntradaDeLetraInserindoCaracteresEspeciais().verificar(novoNome)) {

								System.out.println("Tem certeza que deseja altera de " + aluno.getNome() + " para "
										+ novoNome + " ? [s]/[n]");
								String resposta = scan.next().toLowerCase();
								if (resposta.equals("s")) {
									aluno.setNome(novoNome);
								}
								List<Aluno> list = CONTROLEGERAL.transformaMapEmListAluno();
								for (Aluno cada : list) {
									if (cada.getNome().equals(novoNome)) {
										cada.setNome(novoNome);
									}
								}
								System.out.println("Nome alterado com SUCESSO !!");
								new GeradorCSV(scan).gravarCsvApartirDosMapsDoMomento();
								break;
							}
						case 2:
							System.out.println("---------------------------------------------");
							System.out.println("RESULTADO:-----------------------------------");
							Map<Integer, CadastroCursoAluno> todosCursosRegistradoNoIdPassado = fabricaDeCursoAluno
									.buscaTodosPorId(id);
							System.out.println("---------------------------------------------");

							System.out.println("Digite curso que deseja alterar por ID...");
							String curso = scan.next();
							if (new EntradaDeNumeroInserindoLetra().verificar(curso)) {
								if (todosCursosRegistradoNoIdPassado.containsKey(Integer.parseInt(curso))) {

									FabricaCadastroCursoAluno fcca = new FabricaCadastroCursoAluno();
									CadastroCursoAluno cursoAluno = fcca.buscaPorId(Integer.parseInt(curso));
									System.out.println("---------------------------------------------");
									System.out.println();
									System.out.println("Selecione oque você deseja altera do Rendimento "
											+ cursoAluno.getCurso().getNome() + " do Aluno "
											+ cursoAluno.getAluno().getNome());

									System.out.println(
											"[1]PROVA 1 | [2]PROVA 2 | [3]EXAME | [4]REPOSICAO | [5] EXCLUIR CURSO ");
									String nextInt2 = scan.next();

									if (new EntradaDeNumeroInserindoLetra().verificar(nextInt2)) {
										new TabelaCarregandoTodosOsRendimentosControle().getLista()
												.get(Integer.parseInt(nextInt2)).executar(cursoAluno, scan, fcca);
										new GeradorCSV(scan).gravarCsvApartirDosMapsDoMomento();
									}
								}

							}
							break;
						default:
							break;
						}
					}
				}
			}

		}catch(VerificarSeDoubleException e) {
			
		}
	}

}
