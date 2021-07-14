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
import eterrapn.reps.ClNamenaObjRepository;

@RestController
public class ClNamenaObjRestController {

	@Autowired
	private ClNamenaObjRepository clNamenaObjRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	

	@CrossOrigin
	@RequestMapping(path = "clnamenaobj", method = RequestMethod.GET)
	public Collection<Cl_namenaobj> getNamenaobj() {
		
		
		return clNamenaObjRepository.findAll();
	}
	
	
	//delete
		@CrossOrigin
		@RequestMapping(value = "clnamenaobj/{pnid}", method = RequestMethod.DELETE)
		public ResponseEntity<Cl_namenaobj> deleteNamenaobj(@PathVariable ("pnid") Integer pnid){
			clNamenaObjRepository.deleteById(pnid);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		
		//insert 
	    @CrossOrigin
		@PostMapping("clnamenaobj")
		public ResponseEntity<Cl_namenaobj> insertNamenaobj(@RequestBody Cl_namenaobj namenaobj){
			clNamenaObjRepository.save(namenaobj);
				return new ResponseEntity<>(HttpStatus.OK);
		}
		
		
		
		// update
		@CrossOrigin
		@PutMapping("clnamenaobj")
		public ResponseEntity<Cl_namenaobj> updateNamenaobj(@RequestBody Cl_namenaobj namenaobj){
			if(!clNamenaObjRepository.existsById(namenaobj.getPnid()))
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			clNamenaObjRepository.save(namenaobj);
			return new ResponseEntity<>(HttpStatus.OK);
		}

	
}
