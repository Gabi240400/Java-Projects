import java.util.Vector;

public class Main {
	
	public static void main(String[] args) {                 //main
	
		Vector<Polynomial> pol = new Vector<Polynomial>();
		Repo repo = new Repo(pol);
		Service serv = new Service(repo);
		Console1 c = new Console1(serv);
		
		Vector<Integer> vec1 = new Vector<Integer>();        //populez repo-ul cu niste polinoame
		vec1.add(6);
		vec1.add(11);
		vec1.add(6);
		vec1.add(1);
		serv.add_pol(3, vec1);
		
		vec1.clear();
		vec1.add(8);
		vec1.add(14);
		vec1.add(7);
		vec1.add(1);
		serv.add_pol(3, vec1);
		
		vec1.clear();
		vec1.add(-3);
		vec1.add(-1);
		serv.add_pol(1, vec1);
		
		vec1.clear();
		vec1.add(0);
		vec1.add(1);
		vec1.add(1);
		serv.add_pol(2, vec1);
		
		vec1.clear();
		vec1.add(0);
		vec1.add(0);
		vec1.add(0);
		vec1.add(-1);
		serv.add_pol(3, vec1);
		
		c.run();

	}

}
