package GeradorCSV;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import aula.cadastro.CadastroCursoAluno;

public class ProcuraPorAnoPeloCursoSelecionadoCSV {

	public void gravar(List<CadastroCursoAluno> lista, String ano) {
		System.out.println("Iniciando gravacão do .csv...");
		
		String stringFormatada = new String();
		
		for (CadastroCursoAluno cada : lista) {
			String formatada = cada.getAluno().getId() + ";" + cada.getRendimento().getNp1() + ";"
					+ cada.getRendimento().getNp2() + ";" + cada.getRendimento().getExame() + ";"
					+ cada.getRendimento().getReposicao() + ";" + cada.getRendimento().getMedia() + "\n";

			stringFormatada += formatada;
		}

		if (lista.size() != 0) {
			String novoNomeCSV = "RESULTADOS/" + lista.get(0).getCurso().getNome() + "_"
					+ lista.get(0).getCurso().getNivel().name() + "_" + ano + ".csv";

			try (FileWriter fw = new FileWriter(new File(novoNomeCSV))) {
				fw.write(stringFormatada);
				System.out.println("-------------------------------------");
				System.out.println("Novo csv gerado com sucesso " + novoNomeCSV);
				System.out.println("-------------------------------------");
			} catch (IOException e) {
				System.out.println("Ocorreu este problema " + e.getMessage());
			}

		} else {
			System.out.println("NÃO FOI ENCONTRADO NENHUM REGISTRO EM" + ano);
		}
	}
}
