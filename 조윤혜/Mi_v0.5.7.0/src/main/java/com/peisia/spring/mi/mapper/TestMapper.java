package com.peisia.spring.mi.mapper;

import com.peisia.spring.mi.dto.TestDto;

public interface TestMapper {
	public TestDto getData1();
	public TestDto getData2();
	public TestDto getData3();
	public TestDto getData4();
	public void updateVisitantCount();	//문제1
	public void insertDoodle();			//문제2
	public void delTest();				//문제3
	
}

//public class Tiger implement TestMapper{
//	public TestVO getData1() {
//		
//		//1.선언
//		//2.접속
//		//3.st 얻어내고
//		
//		String sql = "SELECT no,str_data from tbl_test where no = 1";
//		
//		ResultSet rs = st.executeQuery(sql); // 4.sql 전송
//		while(rs.next()) {	//5.전송 결과 꺼내기
//			String no = rs.getNString("no");
//			String title = //
//		}
//		
//		TestVO <<	//6.그릇에 담기

		//st.close();	rs.close() 포함 // 7. st.close 작업
		//con.close();					// 8. con.close 작업
//	}
//}
