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

import eterrapn.jpa.Kn_pravozem;
import eterrapn.reps.KnPravoZemRepository;

@RestController
public class KnPravoZemRestController {
	
	
	@Autowired
	private KnPravoZemRepository knPravoZemRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@CrossOrigin
	@RequestMapping(path = "knpravozem", method = RequestMethod.GET)
	public Collection<Kn_pravozem> getPravoZem() {
		
		
		return knPravoZemRepository.findAll();
	}
	
	
	//delete
	@CrossOrigin
	@RequestMapping(value = "knpravozem/{pnid}", method = RequestMethod.DELETE)
	public ResponseEntity<Kn_pravozem> deletePravoZem(@PathVariable ("pnid") Integer pnid){
	    knPravoZemRepository.deleteById(pnid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//insert 
    @CrossOrigin
	@PostMapping("knpravozem")
	public ResponseEntity<Kn_pravozem> insertPravoZem(@RequestBody Kn_pravozem pravozem){
		knPravoZemRepository.save(pravozem);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	// update
	@CrossOrigin
	@PutMapping("knpravozem")
	public ResponseEntity<Kn_pravozem> updatePravoZem(@RequestBody Kn_pravozem pravozem){
		if(!knPravoZemRepository.existsById(pravozem.getPnid()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		knPravoZemRepository.save(pravozem);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
