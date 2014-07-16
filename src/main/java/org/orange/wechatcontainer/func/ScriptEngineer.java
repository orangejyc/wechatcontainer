package org.orange.wechatcontainer.func;
import java.util.Hashtable;
import java.util.Map.Entry;

import javax.script.*;

/**
 * @author  Joson
 */
public class ScriptEngineer {
	private ScriptEngineManager scriptEngineManager=null;
	private Hashtable<String, Object> scriptObjects=new Hashtable<String,Object>();
	private String engnineName="JavaScript";
	
	public Object MyResult=null;
	
	/**
	 * @param engninename
	 * @uml.property  name="engnineName"
	 */
	public void setEngnineName(String engninename)
	{
		this.engnineName=engninename;
	}
	public void AddObject(String Key,Object obj)
	{
		if(this.scriptObjects==null)
			this.scriptObjects=new Hashtable<String,Object>();
		this.scriptObjects.put(Key, obj);
	}	
		
	public Object Run(String Script) throws ScriptException
	{
		return Run(Script, this.scriptObjects);
		/*
		if(this.scriptEngineManager==null)
			 this.scriptEngineManager=new ScriptEngineManager();
		 ScriptEngine se=this.scriptEngineManager.getEngineByName(engnineName);
		 for(Entry<String, Object> entry : this.scriptObjects.entrySet())
		 {
			 se.put(entry.getKey(), entry.getValue());
		 }
		 try {
			return se.eval(Script);				
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
		*/
	}
	
	public Object Run(String Script,Hashtable<String, Object> insertObjects) throws ScriptException
	{
		 if(this.scriptEngineManager==null)
			 this.scriptEngineManager=new ScriptEngineManager();
		 ScriptEngine se=this.scriptEngineManager.getEngineByName(engnineName);
		 if(insertObjects!=null)
		 {
			 for(Entry<String, Object> entry : insertObjects.entrySet())
			 {
				 se.put(entry.getKey(), entry.getValue());
			 }
		 }
//		 try {
			return se.eval(Script);				
//		} catch (ScriptException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}		
	}
	
}
