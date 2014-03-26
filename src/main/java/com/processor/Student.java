package com.processor;

import java.util.Date;

public class Student {

		private int student_id;
		private String pin ;
		private String class_id;
		private String section;
		private String grade;
		private Date  create_date;
		private String create_user;
		
	
		/**
		 * @return the pin
		 */
		public String getPin() {
			return pin;
		}
		/**
		 * @param mpin the pin to set
		 */
		public void setPin(String pin) {
			this.pin = pin;
		}
		/**
		 * @return the class_id
		 */
		public String class_id() {
			return class_id;
		}
		/**
		 * @param class_id the class_id to set
		 */
		public void setClass_id(String class_id) {
			this.class_id = class_id;
		}
		/**
		 * @return the Section
		 */
		public String getSection() {
			return section;
		}
		/**
		 * @param section the section to set
		 */
		public void setSection(String section) {
			this.section = section;
		}
		public String getGrade() {
			return grade;
		}
		public void setGrade(String grade) {
			this.grade = grade;
		}
		public Date getCreate_date() {
			return create_date;
		}
		public void setCreate_date(Date create_date) {
			this.create_date = create_date;
		}
		public String getCreate_user() {
			return create_user;
		}
		public void setCreate_user(String create_user) {
			this.create_user = create_user;
		}
	
		public Integer getStudent_id() {
			return student_id;
		}
		public void setStudent_id(int student_id) {
			this.student_id = student_id;
		}
		
}