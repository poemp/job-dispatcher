package com.opensource.jobdispatcher.service.engine.task;

public enum TriggerFlag {
	
	    SUCC("0000", 0) //触发成功
	    ,PAUSED("9999", 1) //触发未成功，客户端要求暂停
	    ,FAIL("0001",2);  //触发失败
	
	    // 成员变量
	    private String name;
	    private int index;

	    // 构造方法
	    private TriggerFlag(String name, int index) {
	        this.name = name;
	        this.index = index;
	    }
	    
	    // 普通方法
	    public static TriggerFlag getTriggerFlag(String str) {
	    	switch(str){  
	    	    case "UNSTART":
	    	        return TriggerFlag.SUCC;
	    	    case "STARTED":  
	    	        return TriggerFlag.PAUSED;
	    	    }
			return TriggerFlag.FAIL;  
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getIndex() {
	        return index;
	    }

	    public void setIndex(int index) {
	        this.index = index;
	    }
	}