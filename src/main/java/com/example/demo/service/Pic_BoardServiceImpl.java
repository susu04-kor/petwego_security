package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Pic_BoardDao;
import com.example.demo.util.Criteria;
import com.example.demo.vo.LikeItVo;
import com.example.demo.vo.Pic_BoardVo;
import com.example.demo.vo.Pic_Board_FileVo;

//봉현) 5/12
@Service
public class Pic_BoardServiceImpl implements Pic_BoardService {

	@Autowired
	private Pic_BoardDao pic_boardDao;
	
	@Override
	public List<Pic_Board_FileVo> listFile(Criteria cri) throws Exception{
		List<Pic_Board_FileVo> list = pic_boardDao.listFile(cri);
		return list;
	}
	//리스트	
	@Override
	public List<Pic_BoardVo> listPic_Board(Criteria cri) throws Exception{
		return pic_boardDao.listPic_Board(cri);

	}
	
	//전체글 수
	@Override
	public int listCount() throws Exception {
		return pic_boardDao.listCount();
		
	}
	
	//상세
	@Override
	public Pic_BoardVo detailPic_Board(Pic_BoardVo pb) {
		pic_boardDao.upcntLike(pb.getPhoto_no());
		return pic_boardDao.detailPic_Board(pb);
	}
	//상세사진
	@Override
	public Pic_Board_FileVo detailFile(Pic_Board_FileVo pbf) {
		return pic_boardDao.detailFile(pbf);
	}
	
	//게시입력
	@Override
	public int insertPic_Board(Pic_BoardVo pb) {
		int re = -1;
		re = pic_boardDao.insertPic_Board(pb);
		return re;
	}
	
	//사진입력
	@Override
	public int insertfile(Pic_Board_FileVo pbf) {
		int re = -1;
		re = pic_boardDao.insertfile(pbf);
		return re;
	}
	
	//업데이트
	@Override
	public int updatePic_Board(Pic_BoardVo pb) {
		return pic_boardDao.updatePic_Board(pb);

	}
	
	//삭제
	@Override
	public int deletePic_Board(Pic_BoardVo pb) {
		return pic_boardDao.deletePic_Board(pb);

	}

	
//	//파일 상세
//	@Override
//	public Pic_Board_FileVo detailsns_file(Pic_Board_FileVo p) {
//		Pic_Board_FileVo pbf = pic_boardDao.detail(photo_no)_file(p);
//		return pbf;
//	}
	
	//마지막 글번호
	@Override
	public int photo_no() {
		int re = pic_boardDao.photo_no();
		return re;
	}
	
	// 민아) 5/17, 이 두개 필요없음 
//	// 좋아요
//	@Override
//	public int insertlikeit(LikeItVo l) {
//		int re = -1;
//		re = pic_boardDao.insertlikeit(l);
//		return re;
//	}
//
//	// 좋아요 총개수
//	@Override
//	public int likecnt(LikeItVo l) {
//		int re = -1;
//		re = pic_boardDao.likecnt(l);
//		return re;
//	}

}
