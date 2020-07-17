package com.library.jiraapi;

public class Getsummaryissuedetail {
	private Issuefielddata project;
	private String summary;
	private String description;	
	private Issuefieldkey issuetype;

	public Issuefielddata getProject() {
		return project;
	}

	public void setProject(Issuefielddata project) {
		this.project = project;
	}

	public Issuefieldkey getIssuetype() {
		return issuetype;
	}

	public void setIssuetype(Issuefieldkey issuetype) {
		this.issuetype = issuetype;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
