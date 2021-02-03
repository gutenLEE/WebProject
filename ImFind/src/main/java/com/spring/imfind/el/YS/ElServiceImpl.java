
package com.spring.imfind.el.YS;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.imfind.el.EJ.PetVO;
import com.spring.mapper.YS.ElMapper;
@Service("elService")
public class ElServiceImpl implements ElService{
	@Autowired
	private SqlSession sqlSession;
	@Override
	public List<ElVO> getElsedata(String id) {
		
		ElMapper elMapper=sqlSession.getMapper(ElMapper.class);
		List<ElVO>elseList1=elMapper.getElsedata(id);
		List<ElVO>elseList2=elMapper.getElsedata2(id);
		List<ElVO> List = new ArrayList<>();
		List.addAll(elseList1);
		List.addAll(elseList2);
		return List;
	}
	@Override
	public List<ElVO> getPetElsedata(String id) {
				ElMapper elMapper=sqlSession.getMapper(ElMapper.class);
				List<ElVO>elseList1=elMapper.getPetElsedata(id);
				List<ElVO>elseList2=elMapper.getPetElsedata2(id);
				List<ElVO> List = new ArrayList<>();
				List.addAll(elseList1);
				List.addAll(elseList2);
				return List;
	}
	@Override
	public List<ElVO> getElsePaydata(String id) {
		List<ElVO>elseList2=null;
		ElMapper elMapper=sqlSession.getMapper(ElMapper.class);
		elseList2=elMapper.getElsePaydata(id);	
		System.out.println(elseList2.toString());
		return elseList2;
	}
	@Override
	public List<ElVO> getElseWhoReplied(String params) {
		List<ElVO> elseList3=null;
		System.out.println("params:"+ params);
		int param = Integer.parseInt(params);

		ElMapper elMapper=sqlSession.getMapper(ElMapper.class);

		elseList3 = elMapper.getElseWhoReplied(param);
		
		System.out.println("elseList3:whyarethey" + elseList3);//2021202008
		
		return elseList3;
	}
	@Override
	public int insertGrade(ElVO elvo) {		
		ElMapper elMapper=sqlSession.getMapper(ElMapper.class);
		int res = elMapper.insertGrade(elvo);
		
		return res;
	}
	@Override
	public int updatePay_Grade(ElVO elvo) {
		ElMapper elMapper=sqlSession.getMapper(ElMapper.class);
		int res = elMapper.updatePay_Grade(elvo);
		return res;
	}
	@Override
	public int updatePay_GradePet(ElVO elvo) {
		System.out.println("동물 게시 글번호 : " + elvo.getPet_PostNum());
		ElMapper elMapper=sqlSession.getMapper(ElMapper.class);
		int res = elMapper.updatePay_GradePet(elvo);
		return res;
	}
	@Override
	public List<ElVO> getElseWhoRepliedPet(String params) {
		
		List<ElVO> elseList3=null;
		System.out.println("params:"+ params);
		int param = Integer.parseInt(params);

		ElMapper elMapper = sqlSession.getMapper(ElMapper.class);
		elseList3 = elMapper.getElseWhoRepliedPet(param);
		
		System.out.println("elseList3:whyarethey" + elseList3);//2021202008
		
		return elseList3;
	}
	// YS 1.28 연수
	@Override
	public List<ElVO> getStarGrade(String F_Id) {
		// TODO Auto-generated method stub
		ElMapper elMapper=sqlSession.getMapper(ElMapper.class);
		List<ElVO> list =elMapper.getStarGrade(F_Id);
		return list;		
	}

}