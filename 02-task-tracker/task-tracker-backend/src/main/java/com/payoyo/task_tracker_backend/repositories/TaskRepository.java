package com.payoyo.task_tracker_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payoyo.task_tracker_backend.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{}
