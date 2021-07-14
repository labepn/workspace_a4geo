package eterrapn.ctrls;

import java.util.Collection;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import eterrapn.jpa.Kn_Nosilacprava;
import eterrapn.reps.KnNosilacpravaRepository;

@RestController
public class KnNosilacpravaRestController {

	@Autowired
	private KnNosilacpravaRepository knNosilacpravaRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	

	@CrossOrigin
	@RequestMapping(path = "knnosilacprava", method = RequestMethod.GET)
	public Collection<Kn_Nosilacprava> getNosilacprava() {
		
		
		return knNosilacpravaRepository.findAll();
	}
	
	
	//delete
	@CrossOrigin
	@RequestMapping(value = "knnosilacprava/{pnid}", method = RequestMethod.DELETE)
	public ResponseEntity<Kn_Nosilacprava> deleteKnnosilac(@PathVariable ("pnid") Integer pnid){
	    knNosilacpravaRepository.deleteById(pnid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//insert 
    @CrossOrigin
	@PostMapping("knnosilacprava")
	public ResponseEntity<Kn_Nosilacprava> insertKnnosilac(@RequestBody Kn_Nosilacprava knnosilac){
		knNosilacpravaRepository.save(knnosilac);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	// update
	@CrossOrigin
	@PutMapping("knnosilacprava")
	public ResponseEntity<Kn_Nosilacprava> updateKnnosilac(@RequestBody Kn_Nosilacprava knnosilac){
		if(!knNosilacpravaRepository.existsById(knnosilac.getPnid()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		knNosilacpravaRepository.save(knnosilac);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	
}
