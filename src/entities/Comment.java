package entities;

public class Comment {
	
	private String text;
	
	//Construtor vazio, que é uma boa prática de projeto:
	public Comment() {
	}
	
	//Cada comentário recebe uma String que é o texto do comentário:
	public Comment(String text) {
		this.text = text;
	}
	
	//Getters e Setter, porque os atributos são privados:
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}