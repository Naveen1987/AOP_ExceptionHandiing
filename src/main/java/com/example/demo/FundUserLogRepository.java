package com.example.demo;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface FundUserLogRepository extends PagingAndSortingRepository<FundUserLog, String> {
	@Query("SELECT T FROM FUND_USER_LOG T where T.svlScreen like :screenid order by T.svlDate DESC")
	public List<FundUserLog> getLogs(@Param("screenid")String screenid);

	
	@Query("SELECT T FROM FUND_USER_LOG T where T.sno like :SNO AND  T.svlScreen like :screenid order by T.svlDate DESC")
	public List<FundUserLog> getLogs(@Param("SNO")String sno,@Param("screenid")String screenid);
	
	
	@Query("SELECT T FROM FUND_USER_LOG T where T.svlScreen like :screenid order by T.svlDate DESC")
	public Page<FundUserLog> getLogs(@Param("screenid")String screenid,Pageable page);
	
	@Query("SELECT T FROM FUND_USER_LOG T where T.svcUid like :uuid order by T.svlDate DESC")
	public Page<FundUserLog> getUserLogs(
			@Param("uuid")String uuid,
			Pageable page);
	
	@Query("SELECT T FROM FUND_USER_LOG T where "
			+ " T.svcUid like :uuid "
			+ " AND (T.svlScreen IN (:screenType) OR "
			+ " LOWER(T.svlTtype) LIKE LOWER(CONCAT('%',:paramsearch,'%')) OR"
			+ " LOWER(T.svlUserid) LIKE LOWER(CONCAT('%',:paramsearch,'%')) )"
			+ " order by T.svlDate DESC")
	public Page<FundUserLog> getLogs(
			@Param("uuid")String uuid,
			@Param("paramsearch")String paramsearch,
			@Param("screenType")List<String>screenType,
			Pageable page);
	
	@Query("SELECT T FROM FUND_USER_LOG T where "
			+ " T.svcUid like :uuid"
			+ " AND T.svlDate BETWEEN :fromDate AND :toDate"
			+ " order by T.svlDate DESC")
	public Page<FundUserLog> getLogs(
			@Param("uuid")String uuid,
			@Param("fromDate")Calendar fromDate,
			@Param("toDate")Calendar toDate,
			Pageable page);
	
	@Query("SELECT T FROM FUND_USER_LOG T where"
			+ " T.svcUid like :uuid "
			+ " AND (T.svlScreen IN (:screenType) OR "
			+ " LOWER(T.svlTtype) LIKE LOWER(CONCAT('%',:paramsearch,'%')) OR"
			+ " LOWER(T.svlUserid) LIKE LOWER(CONCAT('%',:paramsearch,'%')) )"
			+ " AND T.svlDate BETWEEN :fromDate AND :toDate"
			+ " order by T.svlDate DESC")
	public Page<FundUserLog> getLogs(
			@Param("uuid")String uuid,
			@Param("paramsearch")String paramsearch,
			@Param("screenType")List<String>screenType,
			@Param("fromDate")Calendar fromDate,
			@Param("toDate")Calendar toDate,
			Pageable page);
	
	@Query("SELECT T FROM FUND_USER_LOG T where "
			+ " (T.svlScreen IN (:screenType) OR "
			+ " LOWER(T.svlTtype) LIKE LOWER(CONCAT('%',:paramsearch,'%')) OR"
			+ " LOWER(T.svlUserid) LIKE LOWER(CONCAT('%',:paramsearch,'%')) )"
			+ " order by T.svlDate DESC")
	public Page<FundUserLog> getLogs(
			@Param("paramsearch")String paramsearch,
			@Param("screenType")List<String>screenType,
			Pageable page);
	
	@Query("SELECT T FROM FUND_USER_LOG T where "
			+ "  T.svlDate BETWEEN :fromDate AND :toDate"
			+ " order by T.svlDate DESC")
	public Page<FundUserLog> getLogs(
			@Param("fromDate")Calendar fromDate,
			@Param("toDate")Calendar toDate,
			Pageable page);
	
	@Query("SELECT T FROM FUND_USER_LOG T where"
			+ " (T.svlScreen IN (:screenType) OR "
			+ " LOWER(T.svlTtype) LIKE LOWER(CONCAT('%',:paramsearch,'%')) OR"
			+ " LOWER(T.svlUserid) LIKE LOWER(CONCAT('%',:paramsearch,'%')) )"
			+ " AND T.svlDate BETWEEN :fromDate AND :toDate"
			+ " order by T.svlDate DESC")
	public Page<FundUserLog> getLogs(
			@Param("paramsearch")String paramsearch,
			@Param("screenType")List<String>screenType,
			@Param("fromDate")Calendar fromDate,
			@Param("toDate")Calendar toDate,
			Pageable page);
	
	
}
