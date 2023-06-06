package com.cm0623.repository;

import com.cm0623.model.entity.ToolEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolRepository extends CrudRepository<ToolEntity, String> {
}
