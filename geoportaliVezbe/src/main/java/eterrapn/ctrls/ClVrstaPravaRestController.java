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

import eterrapn.jpa.Cl_vrstaprava;
import eterrapn.reps.ClVrstaPravaRepository;

@RestController
public class ClVrstaPravaRestController {
	
	@Autowired
	private ClVrstaPravaRepository clVrstaPravaRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@CrossOrigin
	@RequestMapping(path = "clvrstaprava", method = RequestMethod.GET)
	public Collection<Cl_vrstaprava> getVrstaPrava() {
		
		
		return clVrstaPravaRepository.findAll();
	}
	
	//delete
	@CrossOrigin
	@RequestMapping(value = "clvrstaprava/{pnid}", method = RequestMethod.DELETE)
	public ResponseEntity<Cl_vrstaprava> deleteVrstaPrava(@PathVariable ("pnid") Integer pnid){
		clVrstaPravaRepository.deleteById(pnid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//insert 
    @CrossOrigin
	@PostMapping("clvrstaprava")
	public ResponseEntity<Cl_vrstaprava> insertVrstaPrava(@RequestBody Cl_vrstaprava vrstaprava){
		clVrstaPravaRepository.save(vrstaprava);
			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	// update
	@CrossOrigin
	@PutMapping("clvrstaprava")
	public ResponseEntity<Cl_vrstaprava> updateVrstaPrava(@RequestBody Cl_vrstaprava vrstaprava){
		if(!clVrstaPravaRepository.existsById(vrstaprava.getPnid()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		clVrstaPravaRepository.save(vrstaprava);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
