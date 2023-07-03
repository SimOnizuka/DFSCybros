package it.uniba.dib.mfs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniba.dib.mfs.model.SystemFeedback;

public interface SystemFeedbackRepository extends JpaRepository<SystemFeedback, Long> {

}
