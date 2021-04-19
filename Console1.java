import java.util.Scanner;
import java.util.Vector;

public class Console1 {
	Service service;
	
	public Console1(Service serv){
		this.service = serv;
	}
	
	//citirea unui intreg de la tastatura
	public int read_int(String str) {                                     
		System.out.print(str);
		try {
			Scanner s = new Scanner(System.in);
			int i = s.nextInt();
			return i;
		}
		catch(Exception exp){
			System.out.println("Comanda nu este valida!");
			return read_int(str);
		}
	}
	
	//citirea gradului unui poliom
	public int read_degree() {  
		try {
			int degree = this.read_int("Care este gradul polinomului pe care doriti sa il introduceti?");
			if(degree < 1)
				throw new IllegalArgumentException("Gradul unui polinom nu poate fi 0 sau negativ. Introduceti un alt grad!");
			return degree;
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
			return read_degree();
		}
	}
	
	//citirea coeficientilor unui polinom
	public Vector<Integer> read_coef(int degree) throws ArithmeticException, NumberFormatException, IllegalArgumentException{
		try {
			System.out.println("Introduceti coeficientii incepand cu termenul liber: ");
			Scanner s = new Scanner(System.in);
			String str = s.nextLine();
			String[] arg = str.split(" ");
			if(arg.length != degree + 1)
				throw new ArithmeticException("Nu ati dat un numar bun de coeficienti. Introduceti alti coeficienti!");
			Vector<Integer> coef = new Vector<Integer>();
			for(int i = 0; i < arg.length; i++)
				coef.add(Integer.valueOf(arg[i]));
			if(coef.get(coef.size()-1) == 0)
				throw new IllegalArgumentException("Nu ati introdus un polinom cu gradul corespunzator. Introduceti alti coeficienti!");
			return coef;
		}
		catch(ArithmeticException e) {
			System.out.println(e);
			return read_coef(degree);
		}
		catch(NumberFormatException e) {
			System.out.println("Coeficientii introdusi nu sunt buni. Introduceti alti coeficienti!");
			return read_coef(degree);
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
			return read_coef(degree);
		}
	}
	
	//afisarea meniului
	public void menu() {
		System.out.println("1. Adaugati un polinom.");
		System.out.println("2. Afisati polinoamele care au cel putin o radacina comuna si radacinile comune ale acestora.");
		System.out.println("3. Afisati toate polinoamele introduse pana in acest moment.");
		System.out.println("4. Exit.");
	}
	
	//citirea unei optiuni
	public int read_opt() {
		try {
			int opt = read_int("Ce optiune alegeti?");
			if (opt != 1 && opt != 2 && opt != 3 && opt != 4)
				throw new IllegalArgumentException("Optiunea aleasa nu este valida. Alegeti o alta optiune!");
			return opt;
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
			return read_opt();
		}		
	}
	
	//functia principala care trateaza fiecare optiune din meniu
	public void run(){
		this.menu();
		int opt = this.read_opt();
		int ok = 1;
		while(ok == 1) {
			switch(opt) {
				case 1:
					int degree = this.read_degree();
					Vector<Integer> coef = this.read_coef(degree);
					service.add_pol(degree, coef);
					this.menu();
					opt = this.read_opt();
					break;
				case 2:
					String str = service.show_common_roots();
					System.out.print(str);
					this.menu();
					opt = this.read_opt();
					break;
				case 3:
					String strr = service.show_all();
					System.out.print(strr);
					this.menu();
					opt = this.read_opt();
					break;
				case 4:
					ok = 0;
					System.out.print("La revedere!");
					break;
			}
			
		}
	}
}
