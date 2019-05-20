
public class Node implements Comparable<Node>{
	int id;
	Person self;
	Integer p1;
	Integer p2;
	

	@Override
	public int compareTo(Node node) {
		int self = this.self.compareTo(node.self);
		return self == 0 ? this.self.compareTo(node.self) : self;
	}
	
	public Node(int id, Person self, Integer p1, Integer p2) {
		super();
		this.id = id;
		this.self = self;
		this.p1 = p1;
		this.p2 = p2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person getSelf() {
		return self;
	}

	public void setSelf(Person self) {
		this.self = self;
	}

	public Integer getP1() {
		return p1;
	}

	public void setP1(Integer p1) {
		this.p1 = p1;
	}

	public Integer getP2() {
		return p2;
	}

	public void setP2(Integer p2) {
		this.p2 = p2;
	}

	public String toString() {
		return "Node 1:" + this.self;
	}

}
