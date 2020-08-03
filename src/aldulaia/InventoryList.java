package aldulaia;

import java.util.ArrayList;


public class InventoryList {
    
    private ArrayList<Inventory> invList = new ArrayList ();
    
    public InventoryList () {}
    
    public void add (Inventory inventory) {
    invList.add(inventory);
    }
    
    public Inventory get (int index) {
    return invList.get(index);
    }
    
    public int length () {
   return invList.size();
    }
    
    @Override
    public String toString () {
    StringBuilder s = new StringBuilder();
    for(Inventory e : invList) {
    s.append(e.toString());
    s.append("\n");
    }
    return s.toString();
        
    }

}