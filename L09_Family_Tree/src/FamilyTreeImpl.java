import java.util.List;
import java.util.Set;

public class FamilyTreeImpl implements FamilyTree {
	static int id = 0;

	public FamilyTreeImpl(Person p1, Person p2) {
		p1 = null;
		p2 = null;
	}

	@Override
	public void add(Person self, Integer p1, Integer p2) {
		Node person = new Node(id++, self, p1, p2);
		
	}

	@Override
	public Set<Node> getAll() {
		return null;
	}

	@Override
	public Set<Person> getDescendants(int nodeNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getParents(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getPersonsByName(String lastName, String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
