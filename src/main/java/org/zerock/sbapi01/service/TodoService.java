package org.zerock.sbapi01.service;

import org.zerock.sbapi01.dto.PageRequestDTO;
import org.zerock.sbapi01.dto.PageResponseDTO;
import org.zerock.sbapi01.dto.TodoDTO;

public interface TodoService {

    Long register(TodoDTO todoDTO);

    TodoDTO get(Long tno);

    void modify(TodoDTO todoDTO);

    void remove(Long tno);

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
}
