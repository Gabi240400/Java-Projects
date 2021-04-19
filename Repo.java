import java.util.Vector;

public class Repo {
	Vector<Polynomial> pol;
	
	public Repo(Vector<Polynomial> pol) {                                       //constructor cu parametrii
		this.pol = pol;
	}
	
	public void add_pol(Polynomial pol) {                                       //adauga un polinom
		this.pol.add(pol);
	}
	
	public Vector<Integer> get_roots(Polynomial pol){                           //returneaza radacinile unui polinom
		Vector<Integer> roots = pol.get_int_roots();
		return roots;
	}
	
	public Vector<Integer> get_common_roots(Polynomial pol1, Polynomial pol2){  //returneaza radacinile comune a doua polinoame
		Vector<Integer> common_roots = new Vector<Integer>();
		Vector<Integer> pol1_roots = this.get_roots(pol1);
		Vector<Integer> pol2_roots = this.get_roots(pol2);
		for(int i = 0; i < pol1_roots.size(); i++)
			for(int j = 0; j < pol2_roots.size(); j++)
				if(pol1_roots.get(i) == pol2_roots.get(j))
					common_roots.add(pol1_roots.get(i));
		return common_roots;
	}
	
	public String show_common_roots(Polynomial pol1, Polynomial pol2) {          //returneaza un string cu o perechea de 
		String common_roots = new String("");                                    //polinoame si radacinile lor comune
		Vector<Integer> roots = this.get_common_roots(pol1, pol2);
		if(roots.size() == 0)
			return common_roots;
		common_roots = String.format("|%-15s|%-15s|%-15s|\n",pol1.to_string(), pol2.to_string(), roots);
		return common_roots;
	}
	
	public String show_common_roots_all() {                                      //returneaza un string cu toate perechie de
		String common_roots_all = new String("");                                //polinoame care au cel putin o radacina comuna
		int ok = 0;
		common_roots_all = String.format("|%-15s|%-15s|%-15s|\n","Polinomul 1", "Polinomul 2", "Radacini comune");
		common_roots_all += "|===============================================|\n"; 
		for(int i = 0; i < this.pol.size() - 1; i++)
			for(int j = i+1; j < this.pol.size(); j++) {
				Polynomial pol1 = this.pol.get(i);
				Polynomial pol2 = this.pol.get(j);
				common_roots_all += this.show_common_roots(pol1, pol2);
				if(common_roots_all != "")
					ok = 1;
			}
		if(ok == 0)	{
			common_roots_all = "";
			common_roots_all += "Nu exista polinoame care sa aiba radacini intregi comune";
		}
		return common_roots_all;
	}
	
	public String show_all_pol() {                                               //returneaza un string cu toate polinoamele
		String all_pol = new String("");
		for(int i = 0; i < this.pol.size(); i++)
			all_pol += (this.pol.get(i).to_string() + "\n");
		return all_pol;
	}
}
