package org.arm.resource.mngt.entity;

public enum ExceptionMessage {
	
	CampaignDataEmpty("Sorry to Say this Man!! U r Data is Empty😥😥"),
	CampaignIdNotFound("Hey Dude... Check Your Id Once!!"),
	CampaignOwnerNotFound("Huff... Owner is Wrong Dude!!!"),
	TaskDataEmpty("Juss Asking....Have u Set ur Data");
	
	
	
	

	private String message;
	
	

	private ExceptionMessage(String message) {
		this.message=message;
		
	}

	public String getMessage() {
		return message;
	}
	
}

