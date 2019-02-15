package edu.sample.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sample.rest.entity.SystemPreference;

public interface SystemPreferenceRepository extends JpaRepository<SystemPreference, Long> {

}
