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

import eterrapn.jpa.Cl_namenaobj;
import eterrapn.jpa.Cl_tipnosiocaprava;
import eterrapn.reps.ClTipnosiocapravaRepository;

@RestController
public class ClTipnosiocapravaRestController {

	@Autowired
	private ClTipnosiocapravaRepository clTipnosiocapravaRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	

	@CrossOrigin
	@RequestMapping(path = "cltipnosiocaprava", method = RequestMethod.GET)
	public Collection<Cl_tipnosiocaprava> getTipnosiocaprava() {
		
		
		return clTipnosiocapravaRepository.findAll();
	}
	
	
	//delete
			@CrossOrigin
			@RequestMapping(value = "cltipnosiocaprava/{pnid}", method = RequestMethod.DELETE)
			public ResponseEntity<Cl_tipnosiocaprava> deleteTipnosioca(@PathVariable ("pnid") Integer pnid){
				clTipnosiocapravaRepository.deleteById(pnid);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
			
			//insert 
		    @CrossOrigin
			@PostMapping("cltipnosiocaprava")
			public ResponseEntity<Cl_tipnosiocaprava> insertTipnosioca(@RequestBody Cl_tipnosiocaprava tipnosioca){
				clTipnosiocapravaRepository.save(tipnosioca);
					return new ResponseEntity<>(HttpStatus.OK);
			}
			
			
			
			// update
			@CrossOrigin
			@PutMapping("cltipnosiocaprava")
			public ResponseEntity<Cl_tipnosiocaprava> updateTipnosioca(@RequestBody Cl_tipnosiocaprava tipnosioca){
				if(!clTipnosiocapravaRepository.existsById(tipnosioca.getPnid()))
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				clTipnosiocapravaRepository.save(tipnosioca);
				return new ResponseEntity<>(HttpStatus.OK);
			}

	
}
