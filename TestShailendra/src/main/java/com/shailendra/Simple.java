package com.shailendra;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.jboss.logging.Logger;





/**
 * Servlet implementation class Simple
 */
@WebServlet("/Simple")
public class Simple extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	private static final Logger LOGGER = Logger.getLogger(Simple.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Simple() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String inputName=request.getParameter("username");
		
		
		String remoteAddr = request.getRemoteAddr();
		
		String requestURI =request.getRequestURI();

		// client's hostname
		String remoteHost = request.getRemoteHost();
		
		InetAddress addr = InetAddress.getByName(request.getRemoteAddr());
		String  hostName = addr.getHostName();
		
		//DOMErrorImpl dom=new DOMErrorImpl();
		
//	    Test tt=new Test();
//		if(true)
//		{
//			LOGGER.fatal("SHAILENDRA");
//			LOGGER.error("Shailendra Error");
//			LOGGER.warn("Shailendra info");
//			LOGGER.info("Shailendra info");
//			LOGGER.debug("Shailendra info");
//			LOGGER.trace("Shailendra info");
//			
//		}
//	    for (int i = 0; i < 1000; i++) {
//			Runnable task = new MyRunnable(i);
//			Thread worker = new Thread(task);
//			worker.start();
//	    	
//	    	JMSEngine.getInstance().sendRequest("Helloc Shailendra");
//		}
	    
//	    Connector cc= new Connector();
//	    int i= 0;
//	    try {
//			i=cc.countMessagesInQueue("test");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		request.setAttribute("Name",inputName+"-----Host= "+remoteHost+"-------IP"+remoteAddr+"--------HOSTNAme=" +hostName+"----requestURI"+requestURI);
//		request.setAttribute("Module","OutPut from Jar ="+tt.getImplName()+ "Test Queue Count"+i);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
