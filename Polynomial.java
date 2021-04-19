import java.util.Vector;
import java.util.HashMap;

public class Polynomial {
	int degree;
	Vector<Integer> coef;
	
	public Polynomial(int degree, Vector<Integer> coef) {     			 //constructor cu parametrii
		this.degree = degree;
		this.coef = new Vector<Integer>();
		for(int i = 0; i <= degree; i++)
			this.coef.add(coef.get(i));
	}
	
	public int get_degree() {                                            //returneaza gradul unui polinom
		return this.degree;
	}
	
	public Vector<Integer> get_coef() {                                  //returneaza coeficientii polinomului
		return this.coef;
	}
	
	public boolean check_if_root(int root) {                             //verifica daca un numar este radacina
		int sum = 0;
		for(int i = 0; i < this.coef.size(); i++)
			sum = sum + (int) Math.pow(root, i) * this.coef.get(i);
		if (sum == 0)
			return true;
		return false;
	}
	
	public Vector<Integer> get_int_roots(){                              //returneaza toate radacinile intregi ale polinomului
		UsefulMethods u = new UsefulMethods();
		int a0 = this.coef.get(0);
		int an = this.coef.get(this.degree);
		Vector<Integer> int_possible_roots = new Vector<Integer>();
		if(a0 != 0) {                                                    //cazul in care termenul liber este diferit de 0
			Vector<Integer> div_a0 = u.get_div(a0);
			Vector<Integer> div_an = u.get_div(an);
			int_possible_roots = u.get_possible_int_roots(div_a0, div_an);
		}
		else {                                                           //termenul liber este 0
			int index = 1;
			while(a0 == 0) {                                             //retin in a0 primul coeficient diferit de 0
				if(this.coef.get(index) != 0)
					a0 = this.coef.get(index);
				else
					index++;	
			}
			index--;
			if(index != this.degree) {
				Vector<Integer> div_a0 = u.get_div(a0);
				Vector<Integer> div_an = u.get_div(an);
				int_possible_roots = u.get_possible_int_roots(div_a0, div_an);
			}
			int_possible_roots.add(0);                                   //0 este solutie a polinomului
		}
		HashMap<Integer, Boolean> roots = u.get_possible_int_roots(int_possible_roots);
		for(int root: roots.keySet()) {
			boolean is_root = this.check_if_root(root);
			if (!is_root)
				roots.replace(root, false);                             //daca cheia nu este radacina, ii atribui false
		}
		Vector<Integer> vec_roots = new Vector<Integer>();
		for(int root: roots.keySet())
			if(roots.get(root) == true) 
				vec_roots.add(root);                                    //adaug radacinile in vector
		return vec_roots;
	}
	
	public String mon_to_string(int coef, int pow) {                   //returneaza scrierea corecta a unei parti de polinom           
		String mon_to_string = new String();                           //de tipul coef*X^pow
		if(coef == 0)
			return mon_to_string;
		if(pow != this.degree && coef > 0)
			mon_to_string += "+";
		if(coef < 0)
			mon_to_string += "-";
		coef = Math.abs(coef);
		if(coef != 1 || (coef == 1 && pow == 0))
			mon_to_string += String.valueOf(coef);
		if(pow == 0)
			return mon_to_string;
		mon_to_string += "X";
		if(pow != 1)
			mon_to_string += ("^" + pow);
		return mon_to_string;
	}
	
	public String to_string() {                                        //returneaza scrierea unui polinom
		String pol_to_string = new String("");
		for(int i = this.coef.size() - 1; i >= 0; i-- )
			pol_to_string += this.mon_to_string(this.coef.get(i), i);
		return pol_to_string;
	}
	
}
