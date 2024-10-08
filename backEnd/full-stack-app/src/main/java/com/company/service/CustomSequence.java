package com.company.service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customSequences")
public class CustomSequence {
	
	@Id
	private String id;
	private Long seq;
	
	public CustomSequence() {
    }

    public CustomSequence(String id, Long seq) {
        this.id = id;
        this.seq = seq;
    }
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	
	

}
