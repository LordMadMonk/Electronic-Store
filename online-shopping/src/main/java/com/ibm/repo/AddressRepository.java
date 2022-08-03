package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.entity.Address;


/** This interface represents Address Repository.
 * @author ANIRBAN BHATTACHARYYA
 *@since 0.0.1
 */
public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	//finds address by user id
	@Query("FROM Address WHERE user_id=:uid")
	List<Address> findAllbyUserId(int uid);
	
}
