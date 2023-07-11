package com.poseidon.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.poseidon.db.DBConnection;
import com.poseidon.dto.MemberDTO;

// 데이터 접속 객체 DAO: Data Access Object
public class MemberDAO {
	// memberList
	public ArrayList<MemberDTO> memberList() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = "select * from member";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		con = DBConnection.getInstance().getConn();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setMno(rs.getInt(1));
				dto.setMname(rs.getString(2));
				dto.setMid(rs.getString(3));
				dto.setMpw(rs.getString(4));
				dto.setMjoindate(rs.getString(5));
				dto.setMgrade(rs.getInt(6));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// login
	public MemberDTO login(String id, String pw) {
		MemberDTO dto = new MemberDTO();
		String sql = "select count(*), mname from member where mid = '" + id + "' AND mpw = '" + pw + "'";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		con = DBConnection.getInstance().getConn();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				dto.setCount(rs.getInt(1));
				dto.setMname(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
}
