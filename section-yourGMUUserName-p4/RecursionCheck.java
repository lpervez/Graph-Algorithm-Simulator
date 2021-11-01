//Todo: Nothing, do not modify this file in any way

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

/**
 *  A class with some recursion check methods.
 */
class RecursionCheck {
	/**
	 *  Print stream to catch the call stack results.
	 */
	static PrintStream recOut = new PrintStream(new ByteArrayOutputStream());
	
	/**
	 *  Static method to log call stack methods discovered to have
	 *  been called recursively.
	 */
	public static void hasRecursion() {
		StackTraceElement[] trace = Thread.currentThread().getStackTrace();
		String method1 = trace[2].getMethodName();
		String method2 = trace[3].getMethodName();
		String method3 = trace[4].getMethodName();
		
		if(method1.equals(method2) && method2.equals(method3)) {
			for(int i = trace.length-1; i > 0; i--)
				if(trace[i].getMethodName().endsWith("RecursionCheck"))
					recOut.println("Recursion for: " + trace[i].getMethodName());
		}
	}
}