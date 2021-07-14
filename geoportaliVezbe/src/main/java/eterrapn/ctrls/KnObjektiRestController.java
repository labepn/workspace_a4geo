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

import eterrapn.jpa.Kn_objekti;
import eterrapn.reps.KnObjektiRepository;

@RestController
public class KnObjektiRestController {
	
	@Autowired
	private KnObjektiRepository knObjektiRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@CrossOrigin
	@RequestMapping(path = "knobjekti", method = RequestMethod.GET)
	public Collection<Kn_objekti> getObjekti() {
		
		
		return knObjektiRepository.findAll();
	}
	
	
	//delete
	@CrossOrigin
	@RequestMapping(value = "knobjekti/{pnid}", method = RequestMethod.DELETE)
	public ResponseEntity<Kn_objekti> deleteObjekti(@PathVariable ("pnid") Integer pnid){
	    knObjektiRepository.deleteById(pnid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//insert 
    @CrossOrigin
	@PostMapping("knobjekti")
	public ResponseEntity<Kn_objekti> insertObjekti(@RequestBody Kn_objekti objekti){
		knObjektiRepository.save(objekti);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	// update
	@CrossOrigin
	@PutMapping("knobjekti")
	public ResponseEntity<Kn_objekti> updateKnnosilac(@RequestBody Kn_objekti objekti){
		if(!knObjektiRepository.existsById(objekti.getPnid()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		knObjektiRepository.save(objekti);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
