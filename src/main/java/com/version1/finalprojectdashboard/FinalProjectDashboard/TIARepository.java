package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TIARepository extends JpaRepository<TIA, Integer> {

}
