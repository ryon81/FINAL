package net.account.db;

import java.sql.Date;

public class AccountBean 
{	
	//----------REGISTER 테이블 컬럼 정보-----------
	private long USER_NO;
	private String ACCID;
	private String PASSWORD;
	private String NAME;
	private int AGE;
	private String GENDER;	
	private String EMAIL;
	private Date REGDATE;
	
	//----------ACCOUNTMGR 테이블 컬럼 정보-----------
	private long ACCOUNTNO;
	private String ACCOUNT;
	private String ACCTYPE;
	private int INTEREST;
	private long BALANCE;
	private String USAGE;
	
	//----------INCOME 테이블 컬럼 정보-----------
	private long AMOUNTS;
	private String MEMO;
	private Date INC_DATE;	
	private long CATEGORYNO;
	
	//----------EXPENSES 테이블 컬럼 정보-----------	
	private long EXP_SQ;
	private Date EXP_DATE;	
	
	//----------CATEGORYMGR 테이블 컬럼 정보-----------
	private String CATEGORY;
	private String CATTYPE;
	private int BUDGET;
	public long getUSER_NO() {
		return USER_NO;
	}
	public void setUSER_NO(long uSER_NO) {
		USER_NO = uSER_NO;
	}
	public String getACCID() {
		return ACCID;
	}
	public void setACCID(String aCCID) {
		ACCID = aCCID;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public int getAGE() {
		return AGE;
	}
	public void setAGE(int aGE) {
		AGE = aGE;
	}
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public Date getREGDATE() {
		return REGDATE;
	}
	public void setREGDATE(Date rEGDATE) {
		REGDATE = rEGDATE;
	}
	public long getACCOUNTNO() {
		return ACCOUNTNO;
	}
	public void setACCOUNTNO(long aCCOUNTNO) {
		ACCOUNTNO = aCCOUNTNO;
	}
	public String getACCOUNT() {
		return ACCOUNT;
	}
	public void setACCOUNT(String aCCOUNT) {
		ACCOUNT = aCCOUNT;
	}
	public String getACCTYPE() {
		return ACCTYPE;
	}
	public void setACCTYPE(String aCCTYPE) {
		ACCTYPE = aCCTYPE;
	}
	public int getINTEREST() {
		return INTEREST;
	}
	public void setINTEREST(int iNTEREST) {
		INTEREST = iNTEREST;
	}
	public long getBALANCE() {
		return BALANCE;
	}
	public void setBALANCE(long bALANCE) {
		BALANCE = bALANCE;
	}
	public String getUSAGE() {
		return USAGE;
	}
	public void setUSAGE(String uSAGE) {
		USAGE = uSAGE;
	}
	public long getAMOUNTS() {
		return AMOUNTS;
	}
	public void setAMOUNTS(long aMOUNTS) {
		AMOUNTS = aMOUNTS;
	}
	public String getMEMO() {
		return MEMO;
	}
	public void setMEMO(String mEMO) {
		MEMO = mEMO;
	}
	public Date getINC_DATE() {
		return INC_DATE;
	}
	public void setINC_DATE(Date iNC_DATE) {
		INC_DATE = iNC_DATE;
	}
	public long getCATEGORYNO() {
		return CATEGORYNO;
	}
	public void setCATEGORYNO(long cATEGORYNO) {
		CATEGORYNO = cATEGORYNO;
	}
	public long getEXP_SQ() {
		return EXP_SQ;
	}
	public void setEXP_SQ(long eXP_SQ) {
		EXP_SQ = eXP_SQ;
	}
	public Date getEXP_DATE() {
		return EXP_DATE;
	}
	public void setEXP_DATE(Date eXP_DATE) {
		EXP_DATE = eXP_DATE;
	}
	public String getCATEGORY() {
		return CATEGORY;
	}
	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}
	public String getCATTYPE() {
		return CATTYPE;
	}
	public void setCATTYPE(String cATTYPE) {
		CATTYPE = cATTYPE;
	}
	public int getBUDGET() {
		return BUDGET;
	}
	public void setBUDGET(int bUDGET) {
		BUDGET = bUDGET;
	}
	
	
		
	
		
		
}
