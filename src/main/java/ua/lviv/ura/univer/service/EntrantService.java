package ua.lviv.ura.univer.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.ura.univer.dao.EntrantRepository;
import ua.lviv.ura.univer.domain.Entrant;

@Service
public class EntrantService {
	private Logger logger = LoggerFactory.getLogger(EntrantService.class);
	
	@Autowired
	private EntrantRepository entrantRepository;
	
	public Entrant save(Entrant entrant) {
		logger.debug("Save a new entrant " + entrant);
		return entrantRepository.save(entrant);
	}
	
	public List<Entrant> getAllEntants(){
		logger.debug("ALL entrant");
		return entrantRepository.findAll();
	}

}
