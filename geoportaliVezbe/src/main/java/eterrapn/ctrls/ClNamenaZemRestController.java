package eterrapn.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eterrapn.jpa.Cl_namenaobj;
import eterrapn.jpa.Cl_namenazem;
import eterrapn.reps.ClNamenaZemRepository;

@RestController
public class ClNamenaZemRestController {
	
	@Autowired
	private ClNamenaZemRepository clNamenaZemRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@CrossOrigin
	@RequestMapping(path = "clnamenazem", method = RequestMethod.GET)
	public Collection<Cl_namenazem> getNamenazem() {
		
		
		return clNamenaZemRepository.findAll();
	}
	
	//delete
	@CrossOrigin
	@RequestMapping(value = "clnamenazem/{pnid}", method = RequestMethod.DELETE)
	public ResponseEntity<Cl_namenazem> deleteNamenaobj(@PathVariable ("pnid") Integer pnid){
		clNamenaZemRepository.deleteById(pnid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//insert 
    @CrossOrigin
	@PostMapping("clnamenazem")
	public ResponseEntity<Cl_namenaobj> insertNamenaobj(@RequestBody Cl_namenazem namenazem){
		clNamenaZemRepository.save(namenazem);
			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	// update
	@CrossOrigin
	@PutMapping("clnamenazem")
	public ResponseEntity<Cl_namenaobj> updateNamenaobj(@RequestBody Cl_namenazem namenazem){
		if(!clNamenaZemRepository.existsById(namenazem.getPnid()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		clNamenaZemRepository.save(namenazem);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
