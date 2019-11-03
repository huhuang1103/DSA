package dsa;

public class Sorter_Selection implements Sorter {

	private Comparator C;
	@Override
	public void sort(Sequence s) {

	}
	
	public Sorter_Selection() {
		this(new ComparatorDefault());
	}

	public Sorter_Selection(Comparator c) {
		C = c;
	}

	 

}
