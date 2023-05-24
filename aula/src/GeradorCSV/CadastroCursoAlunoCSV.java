package GeradorCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Terminal.CONTROLEGERAL;
import Terminal.Menu.TodosMenus.GeradorCSV;
import aula.cadastro.CadastroCursoAluno;

public class CadastroCursoAlunoCSV {

	public String caminhoCSV() {
		return "DB/cursosAlunos.csv";
	}

	public boolean leitura() {
		try (Scanner CSV = new Scanner(new File(caminhoCSV()))) {
			CONTROLEGERAL.MAP_PRINCIPAL_CADASTRAR_CURSO_NO_ALUNO.clear();
			while (CSV.hasNextLine()) {
				String linha = CSV.nextLine();
				try (Scanner scanlinha = new Scanner(linha)) {
					scanlinha.useLocale(Locale.US);
					scanlinha.useDelimiter(";");
					String id = scanlinha.next();
					String np1 = scanlinha.next();
					String np2 = scanlinha.next();
					String exame = scanlinha.next();
					String reposicao = scanlinha.next();
					String media = scanlinha.next();
					String idCurso = scanlinha.next();
					String idCliente = scanlinha.next();
					String nivel = scanlinha.next();
					CadastroCursoAluno cca = new CadastroCursoAluno(id, np1, np2, exame, media, reposicao, idCurso,
							idCliente, nivel);
					CONTROLEGERAL.MAP_PRINCIPAL_CADASTRAR_CURSO_NO_ALUNO.put(cca.getId(), cca);
					scanlinha.close();
				}
			}
			System.out.println("Lista CadastroCursoAluno atualizada com Sucesso !!");
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("Não encontramos o arquivo de leitura CadastroCursoAluno...");
			return false;

		}

	}

	public boolean procurarNaListPorNome(String nome) {
		List<CadastroCursoAluno> list = CONTROLEGERAL.transformaMapEmListCadastroCursoAluno();
		for (CadastroCursoAluno cada : list) {
			if (cada.getCurso().getNome().equals(nome)) {
				return true;
			}
		}
		;
		return false;
	}
	

	public void gravar() {
		List<CadastroCursoAluno> lista = CONTROLEGERAL.transformaMapEmListCadastroCursoAluno();
		
		String stringFormatada = new String();
		
		for (CadastroCursoAluno cada : lista) {
			String formatada = cada.getId() + ";" + cada.getRendimento().getNp1() + ";"
					+ cada.getRendimento().getNp2() + ";" + cada.getRendimento().getExame() + ";"
					+ cada.getRendimento().getReposicao() + ";" + cada.getRendimento().getMedia() + ";"
					+ cada.getCurso().getId() + ";" + cada.getAluno().getId() + ";"
					+ cada.getRendimento().getNivel().name() + "\n";
			;
			stringFormatada += formatada;
		}

		try (FileWriter fw = new FileWriter(new File("DB/cursosAlunos.csv"))) {
			fw.write(stringFormatada);
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao criar o cursosAlunos.csv");
			System.out.println("Ocorreu este problema " + e.getMessage());
		}

	}
	
	public void limparTudo(Scanner scan) {
		CONTROLEGERAL.MAP_PRINCIPAL_CADASTRAR_CURSO_NO_ALUNO.clear();
		new GeradorCSV(scan).gravarCsvApartirDosMapsDoMomento();
	}
}
