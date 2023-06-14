package com.cm0623.dao;

import com.cm0623.exception.InvalidInputException;
import com.cm0623.model.dto.Tool;
import com.cm0623.model.entity.ToolEntity;
import com.cm0623.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ToolDao {

    private final ToolRepository toolRepository;

    @Autowired
    public ToolDao(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    public Tool getToolById(String toolCode) {
        Optional<ToolEntity> entity = toolRepository.findById(toolCode);
        if(entity.isEmpty()) {
            throw new InvalidInputException("No tool found for the given tool code: "+toolCode);
        }
        return new Tool(entity.get());
    }
}
