package com.kodlama.io.bootCampProject.core.utilities.results;

public class SuccessResult extends Result{
	
	public SuccessResult() {
		super(true);
	} 
	
	public SuccessResult(String message) {
		super(true,message);
	} 

}
