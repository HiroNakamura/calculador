package com.inforhomex.calculador.model;


public class FakeDataSource{

	private String user;
    private String password;
    private String url;

    public FakeDataSource(){}

    public FakeDataSource(String user, String password,String url){
    	super();
    	this.user = user;
    	this.password = password;
    	this.url = url;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}