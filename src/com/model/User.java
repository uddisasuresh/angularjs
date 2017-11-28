    package com.model;
    public class User {
             private int id;
             public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			private String uname;
            private String upass;
            private String email;
        public User(int id,String uname, String upass, String email) {
        	this.id=id;
            this.uname = uname;
            this.upass = upass;
            this.email = email;
        }
        public String getUname() {
            return uname;
        }
        public void setUname(String uname) {
            this.uname = uname;
        }
        public String getUpass() {
            return upass;
        }
        public void setUpass(String upass) {
            this.upass = upass;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
      }