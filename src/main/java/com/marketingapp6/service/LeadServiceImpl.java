package com.marketingapp6.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp6.entities.Lead;
import com.marketingapp6.repositories.LeadRepository;

import antlr.collections.List;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepo;
	private java.util.List<Lead> findAll;
	
	
	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);
	}

	@Override
	public java.util.List<Lead> getAllLeads() {
		java.util.List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteLeadById(long id) {
	leadRepo.deleteById(id);
		
	}

	@Override
	public Lead findLeadById(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		return findById.get();
	}
}

