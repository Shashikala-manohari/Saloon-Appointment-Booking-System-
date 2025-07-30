package com.salon.repository;

import com.salon.modal.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalonRepository extends JpaRepository<Salon,Long> {

    Salon findByOwnerId(Long id);

    @Query(
            "SELECT s FROM Salon s WHERE" +
                    "(lower(s.city) like lower(concat('%',:keyword,'%') ) OR " +
                    "lower(s.name) like lower(concat('%',:keyword,'%') ) OR " +
                    "lower(s.address) like lower(concat('%',:keyword,'%'))) "

    )
    List<Salon> searchSalons(@Param("keyword") String keyword);
}

