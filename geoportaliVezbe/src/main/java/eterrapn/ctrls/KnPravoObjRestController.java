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

import eterrapn.jpa.Kn_pravoobj;
import eterrapn.reps.KnPravoObjRepository;

@RestController
public class KnPravoObjRestController {
	
	@Autowired
	private KnPravoObjRepository knPravoObjRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@CrossOrigin
	@RequestMapping(path = "knpravoobj", method = RequestMethod.GET)
	public Collection<Kn_pravoobj> getPravoObj() {
		
		
		return knPravoObjRepository.findAll();
	}
	
	
	//delete
	@CrossOrigin
	@RequestMapping(value = "knpravoobj/{pnid}", method = RequestMethod.DELETE)
	public ResponseEntity<Kn_pravoobj> deletePravoObj(@PathVariable ("pnid") Integer pnid){
	    knPravoObjRepository.deleteById(pnid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//insert 
    @CrossOrigin
	@PostMapping("knpravoobj")
	public ResponseEntity<Kn_pravoobj> insertPravoObj(@RequestBody Kn_pravoobj pravoobj){
		knPravoObjRepository.save(pravoobj);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	// update
	@CrossOrigin
	@PutMapping("knpravoobj")
	public ResponseEntity<Kn_pravoobj> updatePravoObj(@RequestBody Kn_pravoobj pravoobj){
		if(!knPravoObjRepository.existsById(pravoobj.getPnid()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		knPravoObjRepository.save(pravoobj);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
