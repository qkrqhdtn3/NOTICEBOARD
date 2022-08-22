package com.example.board.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.dao.BoardDAO;
import com.example.board.domain.BoardDTO;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO dao;
	
	@Override
	public List<BoardDTO> list() throws Exception {
		List<BoardDTO> boardDTOList = dao.list();
		SimpleDateFormat prevDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for(BoardDTO boardDTO : boardDTOList){
			String prevDate = boardDTO.getReg_date();
			if(prevDate==null) continue;
			boardDTO.setReg_date(newDateFormat.format(prevDateFormat.parse(prevDate)));
		}
		return boardDTOList;
	}
	
	@Override
	public int regi(BoardDTO dto) throws Exception{
//		log.warn("dao.getMaxSeq() = {}", dao.getMaxSeq());

		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		dto.setReg_date(format.format(date));

		if(dao.getMaxSeq()==null) {
			dto.setSeq(1);
		} else {
			dto.setSeq(dao.getMaxSeq() + 1);
		}
		
		return dao.regi(dto);
	}
	
	@Override
	public BoardDTO view(int seq) {
//		log.warn("service.view()");
		dao.updateReadCount(seq);
		return dao.view(seq).get(0);
	}

	@Override
	public int update(BoardDTO dto) {
//		log.warn("service.update()");
		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {
//		log.warn("service.delete()");
		return dao.delete(seq);
	}
}
