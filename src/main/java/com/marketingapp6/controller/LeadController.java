package com.marketingapp6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp6.dto.LeadDto;
import com.marketingapp6.entities.Lead;
import com.marketingapp6.service.LeadService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;
	
	//http://localhost:8080/create
	
	@RequestMapping("/create")
	public String viewCreateLead() {
		return "create_lead";
	}
	
	@RequestMapping("/saveLead")
    public String saveLead (@ModelAttribute Lead lead ,ModelMap model) {
    leadService.saveLead(lead);
    model.addAttribute("msg", "record is saved!!");
	return "create_lead";
}
	
//	@RequestMapping("/saveLead")
	//public String saveLead(
	//@RequestParam("firstName") String firstname,
		//	@RequestParam("lastName") String lastName,         // //second way to save data into database
		//	@RequestParam("email") String email,
		//	@RequestParam("mobile") long mobile) {

		
		//Lead lead =new Lead();
	//	lead.setFirstName(firstname);
	//	lead.setLastName(lastName);
	//	lead.setEmail(email);
	//	lead.setMobile(mobile);
	//	leadService.saveLead(lead);
	//	return "create_lead";
	
	//@RequestMapping("/saveLead")
	//public String saveLead(LeadDto leadDto) {         // //Third way to save data into database
    
	//	Lead lead = new Lead();
		
	//	lead.setFirstName(leadDto.getFirstName());
	  //  lead.setLastName(leadDto.getLastName());
    //	lead.setEmail(leadDto.getEmail());
    //	lead.setmobile(leadDto.getMobile());
    	
    //	leadService.seveLead(lead);
	//	return"create_lead";
		
		
		//http://localhost:8080/listall


		
		@RequestMapping("/listall")
	 public String getAllLeads(Model model) {
		List<Lead> leads = leadService.getAllLeads();
	model.addAttribute("leads",leads);
		 return "search_result" ;
		}
		
		
		@RequestMapping("/delete")
		public String deleteLeadById(@RequestParam("id") long id,Model model) {
		leadService.deleteLeadById(id);
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads",leads);
		return "search_result" ;	
}
		
		
		@RequestMapping("/update")
		public String getLeadById(@RequestParam("id")long id,Model model) {
			Lead lead = leadService.findLeadById(id);
			model.addAttribute("lead", lead);
			return "update_lead";
		}
		
		
		
		@RequestMapping("/updateLead")
		public String updateLead(LeadDto dto , Model model) {
			Lead l =new Lead();
			l.setId(dto.getId());
			l.setFirstName(dto.getFirstName());
			l.setLastName(dto.getLastName());
			l.setEmail(dto.getEmail());
			l.setMobile(dto.getMobile());
			
			leadService.saveLead(l);
			List<Lead> leads = leadService.getAllLeads();
			model.addAttribute("leads",leads);
			return "search_result";
		}
			
}

		
		
		
		

