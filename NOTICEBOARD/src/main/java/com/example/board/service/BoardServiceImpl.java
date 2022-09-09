package com.example.board.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.board.dao.BoardDAO;
import com.example.board.dao.MemberDAO;
import com.example.board.dao.MemberRepository;
import com.example.board.domain.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

	private final BoardDAO boardDao;
	private final MemberRepository memberRepository;
	
	@Override
	public List<BoardDTO> list() throws Exception {
		List<BoardDTO> boardDTOList = boardDao.list();
		SimpleDateFormat prevDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for(BoardDTO boardDTO : boardDTOList){
			String prevDate = boardDTO.getRegDate();
			if(prevDate==null) continue;
			boardDTO.setRegDate(newDateFormat.format(prevDateFormat.parse(prevDate)));
		}
		return boardDTOList;
	}
	
	@Override
	public int regi(BoardDTO dto) throws Exception{
//		log.warn("boardDao.getMaxBoardId() = {}", boardDao.getMaxBoardId());

		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		dto.setRegDate(format.format(date));

		if(boardDao.getMaxBoardId()==null) {
			dto.setBoardId(1);
		} else {
			dto.setBoardId(boardDao.getMaxBoardId() + 1);
		}
		
		return boardDao.regi(dto);
	}
	
	@Override
	public BoardDTO view(int boardId) {
//		log.warn("service.view()");
		boardDao.updateReadCount(boardId);
		return boardDao.view(boardId).get(0);
	}

	@Override
	public int update(BoardDTO dto) {
//		log.warn("service.update()");
		return boardDao.update(dto);
	}

	@Override
	public int delete(int boardId) {
//		log.warn("service.delete()");
		return boardDao.delete(boardId);
	}
}
