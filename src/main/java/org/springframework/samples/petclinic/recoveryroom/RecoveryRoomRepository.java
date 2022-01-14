package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom,Integer>{
    List<RecoveryRoom> findAll();
    
    @Query("Select distinct rrt FROM RecoveryRoomType rrt")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    Optional<RecoveryRoom> findById(int id);
    
	//RecoveryRoom save(RecoveryRoom p);
    @Query("Select rrt FROM RecoveryRoomType rrt where rrt= :nameR")
    RecoveryRoomType getRecoveryRoomType(@Param("nameR") String nameR);
    
    @Query("Select rr FROM RecoveryRoom rr where rr.size>size")
    List<RecoveryRoom> findBySizeMoreThan(@Param("size") double size);
    

}
