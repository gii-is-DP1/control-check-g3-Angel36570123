package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{

private final RecoveryRoomService RRS;
	
	@Autowired
	public RecoveryRoomTypeFormatter(RecoveryRoomService recoveryRoomService) {
		this.RRS = recoveryRoomService;
	}
	
    @Override
    public String print(RecoveryRoomType object, Locale locale) {
    	return object.getName();
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
    	List<RecoveryRoomType>LRRT=RRS.getAllRecoveryRoomTypes();
    	for(RecoveryRoomType rrt:LRRT) {
    		if(rrt.getName().equals(text)) {
    			return rrt;
    		}
    	}
    	throw new ParseException("recovery_room_type not found: " + text, 0);
    }
    
}
