package edu.kh.oarr.run;

import edu.kh.oarr.medel.service.MemberService;

public class MemberRun {

	public static void main(String[] args) {
		
		MemberService Service = new MemberService();
		
		Service.displayMenu();
		

	}

}
