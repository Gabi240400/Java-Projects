import java.util.Vector;

public class Service {
	Repo repo;
	
	public Service(Repo repo) {                              //constructor cu parametrii
		this.repo = repo;
	}
	
	public void add_pol(int degree, Vector<Integer> coef) {  //adauga un polinom dupa grad si coeficienti
		Polynomial pol = new Polynomial(degree, coef);
		repo.add_pol(pol);
	}
	
	public String show_common_roots() {                      //returneaza un string cu toate perechile de polinoame
		String roots = repo.show_common_roots_all();         // care au cel putin o radacina comuna
		return roots;
	}
	
	public String show_all() {                               //returneaza un string cu toate polinoamele
		String all = repo.show_all_pol();
		return all;
	}
}
