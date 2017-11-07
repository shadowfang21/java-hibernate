package com.sf.learning.hibernate.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long articleId;
	private String title;
	private String content;
	
	private ArticleType articleType;
	private Set<Category> category = new HashSet<Category>();
	private Set<Comment> comment = new HashSet<Comment>();
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.append("articleId", articleId)
			.append("title", title)
			.append("content", content)
			.append("articleType", articleType.getDescription())
			.append("category", category)
			.append("comment", comment)
			.build();
	}
	
	/**
	 * @return the articleId
	 */
	public long getArticleId() {
		return articleId;
	}
	/**
	 * @param articleId the articleId to set
	 */
	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the articleType
	 */
	public ArticleType getArticleType() {
		return articleType;
	}
	/**
	 * @param articleType the articleType to set
	 */
	public void setArticleType(ArticleType articleType) {
		this.articleType = articleType;
	}

	/**
	 * @return the comment
	 */
	public Set<Comment> getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}
	/**
	 * @return the category
	 */
	public Set<Category> getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(Set<Category> category) {
		this.category = category;
	}
	
}
