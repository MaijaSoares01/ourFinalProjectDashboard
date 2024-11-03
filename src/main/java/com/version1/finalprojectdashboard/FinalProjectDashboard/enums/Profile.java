package com.version1.finalprojectdashboard.FinalProjectDashboard.enums;

public enum Profile {
	
	 	GRADUATE("Graduate"),
	    CHANGER("Career changer"),
	    RETURNER("Returner");

	  private final String displayName;
	    
	    Profile(String displayName) {
	        this.displayName = displayName;
	    }
	    
	    public String getDisplayName() {
	        return displayName;
	    }

}
