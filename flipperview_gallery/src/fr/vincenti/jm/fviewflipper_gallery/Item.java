package fr.vincenti.jm.fviewflipper_gallery;

public class Item {
	private boolean clicked;
	private String value;
	private int id;

	public Item(boolean clicked, String value, int id) {
		this.setClicked(clicked);
		this.setId(id);
		this.setValue(value);
	}

	public Item(int id) {
		this.setId(id);
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Item) {
			return (((Item) o).getId() == this.getId());
		}
		return super.equals(o);
	}
}
