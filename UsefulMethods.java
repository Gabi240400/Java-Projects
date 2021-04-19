import java.util.Vector;
import java.util.HashMap;

public class UsefulMethods {
	
	//returneaza divizorii pozitivi ai unui numar intreg
	public Vector<Integer> get_div(int n) {  //returneaza divizorii pozitivi ai unui numar intreg
		Vector<Integer> div = new Vector<Integer>();
		n = Math.abs(n);
		int i = 1;
		while(i <= n) {
			if(n%i == 0)
				div.add(i);
			i++;
		}
		return div;
	}
	
	//returneaza toate numerele intregi pozitive si negative rezultate in urma impartirii divizorilor unui numar la
	//divizorii altui numar
	public Vector<Integer> get_possible_int_roots(Vector<Integer> div_a0, Vector<Integer> div_an){
		Vector<Integer> possible_int_roots = new Vector<Integer>();
		for (int i = 0; i < div_a0.size(); i++)
			for(int j = 0; j < div_an.size(); j++) {
				if(div_a0.get(i) % div_an.get(j) == 0) {
					int div = div_a0.get(i) / div_an.get(j);
					possible_int_roots.add(div);
					possible_int_roots.add(-div);
				}
			}
		return possible_int_roots;
	}
	
	//returneaza un dictionar care are ca chei fiecare numar dintr un vector, alaturi de valoarea true
	public HashMap<Integer, Boolean> get_possible_int_roots(Vector<Integer> possible_roots_dupl){
		HashMap<Integer, Boolean> possible_roots = new HashMap<Integer, Boolean>();
		for(int i = 0; i < possible_roots_dupl.size(); i++) {
			int key = possible_roots_dupl.get(i);
			if (!possible_roots.containsKey(key))
				possible_roots.put(key, true);
		}
		return possible_roots;
	}
}
