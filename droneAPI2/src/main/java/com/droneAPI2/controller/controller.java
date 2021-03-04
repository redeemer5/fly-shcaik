package com.droneAPI2.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.droneAPI2.emailService.emailService;
import com.droneAPI2.models.books;
import com.droneAPI2.models.coordinatesModel;
import com.droneAPI2.models.library;
import com.droneAPI2.models.requestModel;
import com.droneAPI2.models.study_field;
import com.droneAPI2.models.users;
import com.droneAPI2.repo.booksRepo;
import com.droneAPI2.repo.coordinatesRepo;
import com.droneAPI2.repo.libRepo;
import com.droneAPI2.repo.requestRepo;
import com.droneAPI2.repo.studyRepo;
import com.droneAPI2.repo.usersRepo;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class controller {
	
		@Autowired
		private booksRepo brepo;
		
		@Autowired
		private requestRepo Rrepo;
		
		@Autowired
		private emailService eservice;
		
		@Autowired
		private usersRepo users;
		
		@Autowired
		private libRepo librepo;
		
		@Autowired
		private studyRepo studyrepo;
		
		@Autowired
		private coordinatesRepo cRepo;
		
		
		// view user by id
		@GetMapping("/viewuser/{uid}")
		public Optional<com.droneAPI2.models.users> viewUser(@PathVariable int uid)
		{
			return users.findById(uid);
		}
		
	
		// upload/insert new book
		@PostMapping("/addbook")
			public ResponseEntity<Object> addbooks(@Valid @RequestBody books books) 
		{
					books bookModel = brepo.save(books);
			
					URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{b_id}")
							.buildAndExpand(bookModel.getB_id()).toUri();
			
					return ResponseEntity.created(location).build();	
		}
		
		//add new user
		@PostMapping("/adduser")
		public ResponseEntity<Object> adduser(@Valid @RequestBody users user) 
	{
			users userModel = users.save(user);
		
				URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uid}")
						.buildAndExpand(userModel.getUid()).toUri();
		
				return ResponseEntity.created(location).build();	
	}
	
		// view all books
		@GetMapping("/viewbooks")
		public List<books> viewbooks()
		{
			return brepo.findAll();
		}
		
		// view user request
		@GetMapping("/viewPastRequests/{email}")
		public List<requestModel> viewPastRequests(@PathVariable String email)
		{
			return Rrepo.findByEmail(email);
		}
		
		// view all library info
		@GetMapping("/viewlib")
		public List<library> viewlibrary()
		{
			return librepo.findAll();
		}
		
		// view books by study_field
		@GetMapping("/viewbook/{field}")
		public List<books> viewbooksbyfield(@PathVariable String field)
		{
			return brepo.findByField(field);
		}
		
		// view books by book_title
				@GetMapping("/viewbooktitle/{title}")
				public List<books> viewbybooktitle(@PathVariable String title)
				{
					return brepo.findBybooktitle(title);
				}
				
				// view books by library
				@GetMapping("/viewlibrarybooks/{library}")
				public List<books> viewBooksByLibrary(@PathVariable String library)
				{
					return brepo.findBylibrary(library);
				}
		
		
	
		// new book request
		@PostMapping("/bookrequest/{email}/{ordernumber}/{library}/{item}")
			public ResponseEntity<Object> bookrequest(@Valid @RequestBody requestModel request,@PathVariable String email,@PathVariable int ordernumber,@PathVariable String library,@PathVariable String item) 
		{
					//sends the user an email notification
					requestModel rq = new requestModel();
					
					
					// set items to be sent out to the email
					rq.setEmail(email);
					rq.setOrdernumber(ordernumber);
					rq.setLibrary(library);
					rq.setItem(item);
					
					
					// sending email
					try
					{
						eservice.sendEmail(rq);
					}
					catch(MailException ex)
					{
						
					}
					
					
			
					// save's the new request into the database
					requestModel requestModel = Rrepo.save(request);
			
					URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{o_id}")
							.buildAndExpand(requestModel.getO_id()).toUri();
			
					return ResponseEntity.created(location).build();
					
		}
	
		// finds request by library name
		@GetMapping("/request/{library}")
		public List<requestModel> requestByLibrary_Name(@PathVariable String library)
		{
			return Rrepo.findByLibrary(library);
		}
		
		// cancel request
		@DeleteMapping("/cancelRequest/{o_id}")
		public void deleterequest(@PathVariable int o_id)
		{
			Rrepo.deleteById(o_id);
		}
		
		
		// delete book
		@DeleteMapping("/deletebook/{b_id}")
		public void deletebook(@PathVariable int b_id)
		{
			brepo.deleteById(b_id);
		}
		
		// delete user
		@DeleteMapping("/deleteuser/{uid}")
		public void deleteUser(@PathVariable int uid)
		{
			users.deleteById(uid);
		}
		
		
		// delete library
		@DeleteMapping("/deletelib/{l_id}")
		public void deletelibrary(@PathVariable int l_id)
		{
			librepo.deleteById(l_id);
		}
		
		// delete study field
		@DeleteMapping("/deletestudy/{s_id}")
		public void deletestudyField(@PathVariable int s_id)
		{
			studyrepo.deleteById(s_id);
		}
	
	
			//add new library
			@PostMapping("/addlibrary")
			public ResponseEntity<Object> addlibrary(@Valid @RequestBody library lib) 
		{
				library libraryModel = librepo.save(lib);
			
					URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{L_id}")
							.buildAndExpand(libraryModel.getL_id()).toUri();
			
					return ResponseEntity.created(location).build();	
		}
			
			// add new study field
			@PostMapping("/addfield")
				public ResponseEntity<Object> addstudyfield(@Valid @RequestBody study_field studfield) 
			{
				study_field study = studyrepo.save(studfield);
				
						URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{B_id}")
								.buildAndExpand(study.getS_id()).toUri();
				
						return ResponseEntity.created(location).build();	
			}
			
			// getUserEmail&Password
			@GetMapping("/getemailpassword/{email}/{password}")
			public List<users> getEmailAndPassword(@PathVariable String email, @PathVariable String password)
			{
				return users.findByEmailAndPassword(email, password);
			}
			
			
			// get library name and password
			@GetMapping("/getlibpassword/{lib}/{password}")
			public List<library> getlibAndPassword(@PathVariable String lib, @PathVariable String password)
			{
				return librepo.findByLibraryAndPassword(lib, password);
			}
			
			
			// insert or update coordinates
			@PutMapping("/coordinates/{cid}/{longitude}/{latitude}")
			public ResponseEntity<Object> insertUpdateCoordinates(@RequestBody coordinatesModel coords, @PathVariable int cid,@PathVariable String longitude,@PathVariable String latitude)
			{

				coordinatesModel cm = new coordinatesModel();
				
				
				
				cm.setLatitide(latitude);
				cm.setLongitude(longitude);
				
				
				Optional<coordinatesModel> coordinatesid = cRepo.findById(cid);
				if(coordinatesid.isPresent())
				{
					coords.setCid(cid);
					cRepo.save(cm);
				}
				
				else
				{
					coordinatesModel latlong = cRepo.save(cm);
					
					URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cid}")
							.buildAndExpand(latlong.getCid()).toUri();
			
					return ResponseEntity.created(location).build();
				}
				
				return ResponseEntity.noContent().build();
			}
			
			
			// view coordionates
			@GetMapping("/getCoords")
			public List<coordinatesModel> viewCoords()
			{
				return cRepo.findAll();
			}
			
			// update book
			@PutMapping("/updateBook/{b_id}")
			public ResponseEntity<Object> updatebook(@RequestBody books books, @PathVariable int b_id)
			{
				Optional<books> bookid = brepo.findById(b_id);
				if(bookid.isPresent())
				{
					books.setB_id(b_id);
					brepo.save(books);
				}
				
				else
				{
					return ResponseEntity.noContent().build();
				}
				
				return ResponseEntity.noContent().build();
			}
			
			// update user
			@PutMapping("/updateUser/{uid}")
			public ResponseEntity<Object> updateUser(@RequestBody users user, @PathVariable int uid)
			{
				Optional<users> userid = users.findById(uid);
				if(userid.isPresent())
				{
					user.setUid(uid);
					users.save(user);
				}
				
				else
				{
					return ResponseEntity.noContent().build();
				}
				
				return ResponseEntity.noContent().build();
			}
			
			// update library
			@PutMapping("/updateLibrary/{l_id}")
			public ResponseEntity<Object> updateLibrary(@RequestBody library lib, @PathVariable int l_id)
			{
				Optional<library> libid = librepo.findById(l_id);
				if(libid.isPresent())
				{
					lib.setL_id(l_id);
					librepo.save(lib);
				}
				
				else
				{
					return ResponseEntity.noContent().build();
				}
				
				return ResponseEntity.noContent().build();
			}
			
			// update study field
			@PutMapping("/updateStudy/{s_id}")
			public ResponseEntity<Object> updatestudyField(@RequestBody study_field study, @PathVariable int s_id)
			{
				Optional<study_field> studyid = studyrepo.findById(s_id);
				if(studyid.isPresent())
				{
					study.setS_id(s_id);
					studyrepo.save(study);
				}
				
				else
				{
					return ResponseEntity.noContent().build();
				}
				
				return ResponseEntity.noContent().build();
			}
}
