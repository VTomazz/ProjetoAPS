package Terminal.Menu;

import java.util.Scanner;

import Exception.TodasExcecoes;

public class Menus {
	protected Scanner scan;
	protected Integer id;
	
	public Menus(Scanner scan,Integer id) {
		this.scan=scan;
		this.id=id;
	}
	public Menus(Scanner scan) {
		this.scan=scan;
	}
	
	public Scanner getScan() {
		return scan;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void executar() throws TodasExcecoes {};

}
