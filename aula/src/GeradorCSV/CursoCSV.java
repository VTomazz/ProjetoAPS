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
import aula.cadastro.Curso;
import aula.cadastro.NivelGraduacao;

public class CursoCSV {

	public String caminhoCSV() {
		return "DB/curso.csv";
	}

	public boolean leitura() {
		try (Scanner CSV = new Scanner(new File(caminhoCSV()))) {
			CONTROLEGERAL.MAP_PRINCIPAL_CURSO.clear();
			while (CSV.hasNextLine()) {
				String linha = CSV.nextLine();
				try (Scanner scanlinha = new Scanner(linha)) {
					scanlinha.useLocale(Locale.US);
					scanlinha.useDelimiter(";");
					String nome = scanlinha.next();
					String nivel = scanlinha.next();
					String ano = scanlinha.next();
					Curso curso = new Curso(nome, NivelGraduacao.valueOf(nivel), ano);
					CONTROLEGERAL.MAP_PRINCIPAL_CURSO.put(curso.getId(), curso);
					scanlinha.close();
				}
			}
			System.out.println("Lista Curso atualizada com Sucesso !!");
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("Não encontramos o arquivo de leitura Curso...");
			return false;

		}

	}

	public boolean procurarNaListPorNome(Object nome) {
		List<Curso> list = CONTROLEGERAL.transformaMapEmListCurso();
		for (Curso cada : list) {
			if (cada.getNome().equals((String) nome)) {
				return true;
			}
		}
		;
		return false;
	}

	public void gravar() {
		List<Curso> lista = CONTROLEGERAL.transformaMapEmListCurso();
		String stringFormatada = new String();

		for (Curso cada : lista) {
			String formatada = cada.getNome() + ";" + cada.getNivel().name() + ";" + cada.getAno() + "\n";
			stringFormatada += formatada;
		}

		try (FileWriter fw = new FileWriter(new File("DB/curso.csv"))) {
			fw.write(stringFormatada);
		} catch (IOException e) {
			System.out.println("Ocorreu este problema " + e.getMessage());
		}
	}
	
	public void limparTudo(Scanner scan) {
		CONTROLEGERAL.MAP_PRINCIPAL_CURSO.clear();
		new GeradorCSV(scan).gravarCsvApartirDosMapsDoMomento();
	}

}
