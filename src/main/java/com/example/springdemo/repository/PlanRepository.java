package com.example.springdemo.repository;

import com.example.springdemo.models.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long>  {
    Plan findByHashcode(String hashCode);

    @Query(name="select h from Plan h join User u where u.id = id")
    List<Plan> findAllByUserId(@Param("planId") long id);
}