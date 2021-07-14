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

import eterrapn.jpa.Cl_spratnost;
import eterrapn.reps.ClSpratnosRepository;

@RestController
public class ClSpratnostRestController {
	
	@Autowired
	private ClSpratnosRepository clSpratnostRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@CrossOrigin
	@RequestMapping(path = "clspratnost", method = RequestMethod.GET)
	public Collection<Cl_spratnost> getSpratnost() {
		
		
		return clSpratnostRepository.findAll();
	}
	
	//delete
	@CrossOrigin
	@RequestMapping(value = "clspratnost/{pnid}", method = RequestMethod.DELETE)
	public ResponseEntity<Cl_spratnost> deleteSpratnost(@PathVariable ("pnid") Integer pnid){
		clSpratnostRepository.deleteById(pnid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//insert 
    @CrossOrigin
	@PostMapping("clspratnost")
	public ResponseEntity<Cl_spratnost> insertSpratnost(@RequestBody Cl_spratnost spratnost){
		clSpratnostRepository.save(spratnost);
			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	// update
	@CrossOrigin
	@PutMapping("clspratnost")
	public ResponseEntity<Cl_spratnost> updateSpratnost(@RequestBody Cl_spratnost spratnost){
		if(!clSpratnostRepository.existsById(spratnost.getPnid()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		clSpratnostRepository.save(spratnost);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
