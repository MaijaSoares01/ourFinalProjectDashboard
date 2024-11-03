package com.version1.finalprojectdashboard.FinalProjectDashboard.enums;

public enum RejectionStage {
	
	 IN_REVIEW("1. In Review"),
	    TIA("2. TIA"),
	    INTERVIEW("3. Interview"),
	    ASSESSMENT_DAY("4. Assessment Day"),
	    OFFERED("5. Offered"),
	    HIRED("6. Hired");
	    
	    private final String displayName;
	    
	    RejectionStage(String displayName) {
	        this.displayName = displayName;
	    }
	    
	    public String getDisplayName() {
	        return displayName;
	    }
    
    
		/*
		 * //Converts an integer stage number to its rejection stage public static
		 * RejectionStage fromStage(int rejectionStage) { for (RejectionStage rs :
		 * RejectionStage.values()) { if (rs.getRejectionStage() == rejectionStage) {
		 * return rs; } } throw new IllegalArgumentException("Invalid stage number: " +
		 * rejectionStage); }
		 */
}
