package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	
	//Instancia um SimpleDateFormat para ter informação do horário dos posts:
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	private Date moment;
	private String title;
	private String content;
	private Integer likes;
	private Integer index;
	
	//Os comentários estão em uma lista do tipo Comment:S
	private List<Comment> comments = new ArrayList<>();
	
	public Post() {
	}
	//Post recebe o momento que a postagem foi feita, o título do post, o conteúdo do post e a quantidade de likes:
	public Post(Date moment, String title, String content, Integer likes, Integer index) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
		this.index = index;
	}
	
	//Getters e Setter, porque os atributos são privados:
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}
	
	//Os likes não tem setLikes, pois a única forma de aumentar a quantidade de likes de um post é curtindo 
	//com o comandolike:
	public void like() {
		likes +=1;
	}

	public List<Comment> getComments() {
		return comments;
	}
	
	//Os comentários também não tem setComment, pois só é possível adicionar um comentário com o comando addComment:
	public void addComment(Comment comment) {
		comments.add(comment);
	}

	public Integer getIndex() {
		return index;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(index + " - ");
		sb.append(title + "\n");
		sb.append(content + "\n");
		sb.append(sdf.format(moment));
		sb.append(" - ");
		sb.append(likes);
		sb.append(" Likes\n");
		sb.append("\nComentários:\n");
		for(Comment c : comments) {
			sb.append(c.getText() + "\n");
		}
		return sb.toString();
	}
}