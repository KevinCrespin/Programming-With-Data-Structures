
public class Victim {
	public String name; 
	public Integer iQ;
	public Integer appearanceScore;
	
	public Victim(String name, Integer iQ, Integer appearanceScore) {
		
		this.name = name;
		
		if (iQ > 200) {
			this.iQ = 200;
		}
		if (iQ < 50) {
			this.iQ = 50;
		}
		if (iQ <= 200 && iQ >= 50) {
			this.iQ = iQ;
		}
		if (appearanceScore > 10) {
			this.appearanceScore = 10;
		}
		if (appearanceScore < 1) {
			this.appearanceScore = 1;
		}
		if (appearanceScore <= 10 && appearanceScore >= 1) {
			this.appearanceScore = appearanceScore;
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setiQ(Integer iQ) {
		if (iQ > 200) {
			this.iQ = 200;
		}
		if (iQ < 50) {
			this.iQ = 50;
		}
		else {
			this.iQ = iQ;
		}
	}

	public void setAppearanceScore(Integer appearanceScore) {
		if (appearanceScore > 10) {
			this.appearanceScore = 10;
		}
		if (appearanceScore < 1) {
			this.appearanceScore = 1;
		}
		else {
			this.appearanceScore = appearanceScore;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getIQ() {
		return iQ;
	}
	
	public Integer getAppearanceScore() {
		return appearanceScore;
	}
	
	public String toSting() {
		return "Name: " + getName() + " | IQ: " + getIQ() + " | Appearance Score: " + getAppearanceScore();
	}

}
