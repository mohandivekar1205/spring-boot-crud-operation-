package com.example.repository;

import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface EmpRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "SELECT * FROM employees WHERE mobile = :number",nativeQuery = true)
    String findByNumber(@Param("number") long number);

    @Query(value = "SELECT * FROM employees WHERE email = :mail",nativeQuery = true)
    String findByMailAddress(@Param("mail") String mail);
}
