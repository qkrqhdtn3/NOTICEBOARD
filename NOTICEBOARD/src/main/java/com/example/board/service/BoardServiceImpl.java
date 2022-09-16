package com.example.board.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.board.dao.BoardDAO;
import com.example.board.dao.BoardRepository;
import com.example.board.dao.MemberRepository;
import com.example.board.domain.Board;
import com.example.board.domain.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

//    private final BoardDAO boardDao;
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;
    //	@Override
//	public List<BoardDTO> list() throws Exception {
//		List<BoardDTO> boardDTOList = boardDao.list();
//		SimpleDateFormat prevDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//		SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		for(BoardDTO boardDTO : boardDTOList){
//			String prevDate = boardDTO.getRegDate();
//			if(prevDate==null) continue;
//			boardDTO.setRegDate(newDateFormat.format(prevDateFormat.parse(prevDate)));
//		}
//		return boardDTOList;
//	}

//    @Override
//    public int regi(BoardDTO dto) throws Exception {
////		log.warn("boardDao.getMaxBoardId() = {}", boardDao.getMaxBoardId());
//
//        Date date = new Date(System.currentTimeMillis());
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
//        dto.setRegDate(format.format(date));
//
//        if (boardDao.getMaxBoardId() == null) {
//            dto.setBoardId(1);
//        } else {
//            dto.setBoardId(boardDao.getMaxBoardId() + 1);
//        }
//
//        return boardDao.regi(dto);
//    }
//
//    @Override
//    public BoardDTO view(int boardId) {
////		log.warn("service.view()");
//        boardDao.updateReadCount(boardId);
//        return boardDao.view(boardId).get(0);
//    }
//
//    @Override
//    public int update(BoardDTO dto) {
////		log.warn("service.update()");
//        return boardDao.update(dto);
//    }
//
//    @Override
//    public int delete(int boardId) {
////		log.warn("service.delete()");
//        return boardDao.delete(boardId);
//    }

    @Override
    public List<BoardDTO> list() throws Exception {
//        List<Board> boardList = boardDao.list();
        List<Board> boardList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = modelMapper.map(boardList, new TypeToken<List<BoardDTO>>() {}.getType());
        SimpleDateFormat prevDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (BoardDTO board : boardDTOList) {
            String prevDate = board.getRegDate();
            if (prevDate == null) continue;
            board.setRegDate(newDateFormat.format(prevDateFormat.parse(prevDate)));
        }
        return boardDTOList;
    }

    @Override
    public boolean regi(BoardDTO dto) throws Exception {
//		log.warn("boardDao.getMaxBoardId() = {}", boardDao.getMaxBoardId());

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        dto.setRegDate(format.format(date));

//        if (boardRepository.MaxByBoardId().isPresent()) {
//            dto.setBoardId(boardRepository.MaxByBoardId().orElse(0) + 1);
//        } else {
//            dto.setBoardId(1);
//        }
        Board board = modelMapper.map(dto, Board.class);
        if(boardRepository.save(board).getBoardId() == 0){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public BoardDTO view(int boardId) {
//		log.warn("service.view()");
        Board board = boardRepository.findByBoardId(boardId).orElse(null);
        board.setReadCount(board.getReadCount() + 1);
        boardRepository.save(board);
//        boardDao.updateReadCount(boardId);
        BoardDTO boardDTO = modelMapper.map(board, BoardDTO.class);
        return boardDTO;
    }

    @Override
    public boolean update(BoardDTO dto) {
//		log.warn("service.update()");
        Board board = modelMapper.map(dto, Board.class);
        if(boardRepository.save(board).getBoardId() == 0){
            return false;
        } else{
            return true;
        }
    }

    @Override
    public boolean delete(long boardId) {
//		log.warn("service.delete()");
        if(boardRepository.deleteByBoardId(boardId) == 0){
            return false;
        } else{
            return true;
        }
//        return boardDao.delete(boardId);
    }
}
