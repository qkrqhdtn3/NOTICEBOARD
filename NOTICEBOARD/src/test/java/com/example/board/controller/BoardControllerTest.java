package com.example.board.controller;

import com.example.board.domain.Board;
import com.example.board.domain.BoardDTO;
import com.example.board.service.BoardService;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;

import javax.servlet.http.Cookie;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(BoardController.class)
class BoardControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BoardService boardService;

    @Test
    void list() throws Exception {
        // boardService에서 list<BoardDTO> 목록 받아온 후,
        // list<BoardDTO>를 model에 넣어서 보냄
        List<BoardDTO> list = new ArrayList<>();
        Long[] boardId = {1L,2L,3L,4L,5L};
        String[] subject = {"11","12","13","14","15"};
        String[] content = {"21","22","23","24","25"};
        String[] regDate = {"31","32","33","34","35"};
        int[] readCount = {41,42,43,44,45};
        Long[] memberId = {51L,52L,53L,54L,55L};
        String[] memberName = {"61","62","63","64","65"};

        for(int i = 0 ; i < 5 ; i++) {
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setBoardId(boardId[i]);
            boardDTO.setSubject(subject[i]);
            boardDTO.setContent(content[i]);
            boardDTO.setRegDate(regDate[i]);
            boardDTO.setReadCount(readCount[i]);
            boardDTO.setMemberId(memberId[i]);
            boardDTO.setMemberName(memberName[i]);
            list.add(boardDTO);
        }
        when(boardService.list()).thenReturn(list);
//        for(int i = 0 ; i < boardService.list().size() ; i++){
//            System.out.println(boardService.list().get(i).getBoardId()+" "+
//                    boardService.list().get(i).getRegDate()+" "+
//                    boardService.list().get(i).getContent()+" "+
//                    boardService.list().get(i).getSubject()+" "+
//                    boardService.list().get(i).getMemberName()+" "+
//                    boardService.list().get(i).getMemberId()+" "+
//                    boardService.list().get(i).getReadCount());
//        }
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/board/list")
                .flashAttr("list", boardService.list())
                .cookie(new Cookie("name", "홍길동"))
                .characterEncoding(StandardCharsets.UTF_8)
                .contentType("text/plain;charset=UTF-8")
                .locale(Locale.KOREA);
        MvcResult mvcResult = mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/login"))
                .andExpect(MockMvcResultMatchers.status().is(302))
                .andExpect(MockMvcResultMatchers.model().attributeExists("list"))
//                .andExpect(MockMvcResultMatchers.model().attribute("list", list))
                .andDo(MockMvcResultHandlers.print()).andReturn();
        System.out.println("001");
        System.out.println(mvcResult.getResponse().toString());
        System.out.println("002");
//        DocumentContext documentContext = JsonPath.parse(mvcResult.getResponse().getContentAsString());
//        Assertions.assertThat((String)documentContext.read("boardId")).isEqualTo(boardId[0]);
//        System.out.println((String)documentContext.read("boardId"));
    }

    @Test
    void regiView() {
    }

    @Test
    void regi() {
    }

    @Test
    void view() {
    }

    @Test
    void updateView() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void ex1() {
    }

    @Test
    void ex2() {
    }
}