package models;
 
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;
 
@Entity
public class Comment extends Model {
	
	@Required
    public String author;
	
	@Required
    public Date postedAt;
	
    @Required
    @MaxSize(10000) 
    @Lob
    public String content;
    
    @ManyToOne
    @Required
    public Post post;
    
    public Comment(Post post, String author, String content) {
        this.post = post;
        this.author = author;
        this.content = content;
        this.postedAt = new Date();
    }
 
    public String toString() {
        return author + " - " + content.substring(0, 10);
    }
    
}