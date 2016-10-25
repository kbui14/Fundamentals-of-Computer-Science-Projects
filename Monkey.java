package cs225;

public class Monkey {

	private int bananasOwned;
	private boolean isMale;
	private double kgWeight;
	
	
	public Monkey(){
		bananasOwned = 12;
		isMale = false;
		kgWeight = 25;
	}
	
	public Monkey(int bananasOwned, boolean isMale, double kgs) {
		super();
		this.bananasOwned = bananasOwned;
		this.isMale = isMale;
		this.kgWeight = kgs;
	}

	public int getBananasOwned() {
		return bananasOwned;
	}

	public void setBananasOwned(int bananasOwned) {
		this.bananasOwned = bananasOwned;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public double getKgWeight() {
		return kgWeight;
	}

	public void setKgWeight(double kgWeight) {
		this.kgWeight = kgWeight;
	}

	
	public String toString() {
		return "Monkey [bananasOwned=" + bananasOwned + ", isMale=" + isMale
				+ ", kgWeight=" + kgWeight + "]";
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Monkey))
			return false;
		Monkey other = (Monkey) obj;
		if (bananasOwned != other.bananasOwned)
			return false;
		if (isMale != other.isMale)
			return false;
		if (Double.doubleToLongBits(kgWeight) != Double
				.doubleToLongBits(other.kgWeight))
			return false;
		return true;
	}
	
	
}
