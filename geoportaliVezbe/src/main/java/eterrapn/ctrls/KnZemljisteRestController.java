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

import eterrapn.jpa.Kn_zemljiste;
import eterrapn.reps.KnZemljisteRepository;

@RestController
public class KnZemljisteRestController {
	
	@Autowired
	private KnZemljisteRepository knZemljisteRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@CrossOrigin
	@RequestMapping(path = "knzemljiste", method = RequestMethod.GET)
	public Collection<Kn_zemljiste> getZemljiste() {
		
		
		return knZemljisteRepository.findAll();
	}
	
	
	//delete
	@CrossOrigin
	@RequestMapping(value = "knzemljiste/{pnid}", method = RequestMethod.DELETE)
	public ResponseEntity<Kn_zemljiste> deleteZemljiste(@PathVariable ("pnid") Integer pnid){
	    knZemljisteRepository.deleteById(pnid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//insert 
    @CrossOrigin
	@PostMapping("knzemljiste")
	public ResponseEntity<Kn_zemljiste> insertZemljiste(@RequestBody Kn_zemljiste zemljiste){
		knZemljisteRepository.save(zemljiste);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	// update
	@CrossOrigin
	@PutMapping("knzemljiste")
	public ResponseEntity<Kn_zemljiste> updateZemljiste(@RequestBody Kn_zemljiste zemljiste){
		if(!knZemljisteRepository.existsById(zemljiste.getPnid()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		knZemljisteRepository.save(zemljiste);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
