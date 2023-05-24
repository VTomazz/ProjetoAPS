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
import aula.cadastro.Aluno;

public class AlunoCSV {

	public String caminhoCSV() {
		return "DB/aluno.csv";
	}

	public AlunoCSV() {
	}

	public boolean leitura() {
		try (Scanner CSV = new Scanner(new File(caminhoCSV()))) {
			CONTROLEGERAL.MAP_PRINCIPAL_ALUNO.clear();
			while (CSV.hasNextLine()) {
				String linha = CSV.nextLine();
				try (Scanner scanlinha = new Scanner(linha)) {
					scanlinha.useLocale(Locale.US);
					scanlinha.useDelimiter(";");
					String id = scanlinha.next();
					String nome = scanlinha.next();
					Aluno aluno = new Aluno(id, nome);
					CONTROLEGERAL.MAP_PRINCIPAL_ALUNO.put(aluno.getId(), aluno);
					scanlinha.close();
				}
			}
			System.out.println("Lista Aluno atualizada com Sucesso !!");
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("Não encontramos o arquivo de leitura Aluno...");
			return false;

		}

	}

	public boolean procurarNaListPorNome(Object nome) {
		List<Aluno> list = CONTROLEGERAL.transformaMapEmListAluno();
		for (Aluno cada : list) {
			if (cada.getNome().equals((String) nome)) {
				return true;
			}
		}
		;
		return false;
	}

	public void gravar() {
		List<Aluno> lista = CONTROLEGERAL.transformaMapEmListAluno();
		String stringFormatada = new String();

		for (Aluno cada : lista) {
			String formatada = cada.getId() + ";" + cada.getNome() + "\n";
			stringFormatada += formatada;
		}

		try (FileWriter fw = new FileWriter(new File("DB/aluno.csv"))) {
			fw.write(stringFormatada);
		} catch (IOException e) {
			System.out.println("Ocorreu este problema " + e.getMessage());
		}
	}

	public void limparTudo(Scanner scan) {
		CONTROLEGERAL.MAP_PRINCIPAL_ALUNO.clear();
		new GeradorCSV(scan).gravarCsvApartirDosMapsDoMomento();
	}

}
