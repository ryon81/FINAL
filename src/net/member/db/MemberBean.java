package net.member.db;

import java.sql.Date;

public class MemberBean 
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
		
		

}
