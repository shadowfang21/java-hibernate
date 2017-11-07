package com.sf.learning.hibernate.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ArticleType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long articleTypeId;
	private String description;
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.append("articleTypeId", articleTypeId)
			.append("description", description).build();
	}
	
	/**
	 * @return the articleTypeId
	 */
	public long getArticleTypeId() {
		return articleTypeId;
	}
	/**
	 * @param articleTypeId the articleTypeId to set
	 */
	public void setArticleTypeId(long articleTypeId) {
		this.articleTypeId = articleTypeId;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
