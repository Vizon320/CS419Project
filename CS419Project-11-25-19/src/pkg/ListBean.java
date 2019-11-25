package pkg;

import java.util.*;

public class ListBean {
	private List<StoreProduct> list = new ArrayList<StoreProduct>();
	
	/* More can be added, but this is the basic functionality needed */
	/* Currently unused in the project, but keep this .java file */
	
	public List<StoreProduct> getList() {
		return list;
	}
	
	public void setList(List<StoreProduct> list) {
		this.list = list;
	}
	
	public StoreProduct getItemAtIndex(int index) {
		return list.get(index);
	}
	
	public void addToList(StoreProduct p) {
		list.add(p);
	}
	
	public void removeItemWithName(String name) {
		// Go through all items
		for(StoreProduct p : list) {
			if(p.getName() == name) {
				// Remove only one item if name matches
				// Could also remove based on index
				list.remove(p);
				return;
			}
		}
	}
}