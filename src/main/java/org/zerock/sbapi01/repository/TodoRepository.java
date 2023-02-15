package org.zerock.sbapi01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.sbapi01.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
