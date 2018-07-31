package swing;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class CheckBoxRender implements ListCellRenderer<Object>{
	
	private Map<String , JCheckBox> items= new HashMap<>();
	
	public CheckBoxRender(String [] items) {
		
		for (String item : items) {
			
			JCheckBox box= new JCheckBox(item);
			this.items.put(item, box);
			
		}
	}
	
	

	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {
	if(items.containsKey(value)) {
		return items.get(value);
	}
	else {
		return null;
	}

}
	
	public void setSelected(String item, boolean selected) {
		if (item.contains(item)) {
			JCheckBox cb = items.get(item);
			cb.setSelected(selected);
		}
	
	}
	}
