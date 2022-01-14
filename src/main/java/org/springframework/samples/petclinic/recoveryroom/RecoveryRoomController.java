package org.springframework.samples.petclinic.recoveryroom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {
    
	private static final String createOrUpdateRecoveryRoomForm = "recoveryroom/createOrUpdateRecoveryRoomForm";

	@Autowired
	private RecoveryRoomService RRS;
	
	
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@GetMapping(value = "/recoveryroom/create")
	public String initCreationForm(Map<String, Object> model) {
		RecoveryRoom RR= new RecoveryRoom();
		Iterable<RecoveryRoomType>LRRT=RRS.getAllRecoveryRoomTypes();
		
		model.put("types",LRRT);
	
		model.put("recoveryRoom", RR);
		return createOrUpdateRecoveryRoomForm;
	}
	
	@PostMapping(value = "/recoveryroom/create")
	public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result) {
		if (result.hasErrors()) {
			
			return createOrUpdateRecoveryRoomForm;
		}
		else {
			
			this.RRS.save(recoveryRoom);
		
			return "redirect:/";
		}
	}

}
