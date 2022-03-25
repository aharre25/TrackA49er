/**
 * Repository for "UNCC" model. Encapsulates  for retrieval and query of database.
 * @author Group 21 4155
 * @version 1.0
 * @date 3/17/2022
 */

package com.Group21.TrackA49er.repository;

import com.Group21.TrackA49er.model.mykey;

import com.Group21.TrackA49er.model.uncc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface unccRepository extends JpaRepository<uncc, mykey> {
    @Query(value = "SELECT * FROM uncc u WHERE u.tim = ?1 AND u.dow = ?2 order by u.count DESC",

            nativeQuery = true
    )
    List<uncc> findTop3(int tim,String dow);

    @Query(value = "SELECT * FROM uncc u WHERE u.tim = ?1 AND u.dow = ?2 AND (device = 'Atkins' or device ='Barnard' or device = 'Belk Gym' or device = 'Burson' or device = 'cameron' or device = 'cato' or device = 'cedar' or device ='College of education' or device = 'Cone' or device ='EPIC' or device ='Burson' or device = 'Cameron' or device = 'fretwell' or device = 'Kennedy' or device ='Macy' or device ='Prospector' or device = 'South village crossing' or device = 'Woodward' or device = 'Kennedy' or device ='King' or device = 'Macy')   order by u.count ASC",

            nativeQuery = true
    )
    List<uncc> findBottom3(int tim,String dow);


    List<uncc> findByTimAndDevice(int tim,String device);

    List<uncc>  findByDevice(String device);

    List<uncc> findByTim(int tim);


}
