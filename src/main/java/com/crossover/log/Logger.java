package com.crossover.log;

/**
 * 
 * @author koki
 *
 */
public class Logger {

	//TODO : IMPLEMENT LOGGING BY CONF  LEVELS , USE LOG4J OR OTHER
	
	static String WARNING = "WARING";
	
	static String DEBUG = "DEBUG";
	
	static String ERROR = "ERROR";
	
	static String INFO = "INFO";
	
	
	
	public static void logDebug(String msg) {
		log(DEBUG, msg,null);
	}
	
	public static void logInfo(String msg) {
		log(INFO, msg,null);
	}
	
	public static void logWarning(String msg) {
		log(WARNING, msg,null);
	}
	
	public static void logError(String msg, Exception e) {
		log(ERROR, msg, e);
	}
	
	private static void log(String level,String msg, Exception e) {
		System.out.println("**********"+level+"***********");
		//System.out.println(level);
		if (msg != null) System.out.println(msg);
		if (e != null) e.printStackTrace();
		System.out.println("******************************");
	}
	
}
