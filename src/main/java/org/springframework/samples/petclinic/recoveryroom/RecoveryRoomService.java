package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService {
	
	@Autowired
	RecoveryRoomRepository RRrep;
	
    public List<RecoveryRoom> getAll(){
        return RRrep.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return RRrep.findAllRecoveryRoomTypes();
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return RRrep.getRecoveryRoomType(typeName);
    }

    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
        return RRrep.findBySizeMoreThan(size);
    }

    public RecoveryRoom save(RecoveryRoom p) {
        return RRrep.save(p);       
    }

    
}
