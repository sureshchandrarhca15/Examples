package com.redhat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;

public class NativeThreadAnalyzer {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	private static String LOG_FILE = "server.log";

	public static void main(String[] args) {
		if (args.length > 0) {
			LOG_FILE = args[0];
		}

		NativeThreadAnalyzer nativeThread = new NativeThreadAnalyzer();

		System.out.println(LOG_FILE);

		nativeThread.analyze();
	}

	private void analyze() {
		try {
			System.out.println("Using log file: " + LOG_FILE);

			String dataset = System.getProperty("user.dir") + "/" + LOG_FILE;

			File logFile = new File(dataset);

			// FileUtils.readFileToString(new File(fileURL.toURI())).

			BufferedReader br = new BufferedReader(new FileReader(logFile));
			String line;
			
			JVMHelper jvmHelper = new JVMHelper();
			
			String tmpVersionA ="",tmpVersionB="" ; //TODO optimize

			while ((line = br.readLine()) != null) {
				
				
				if (line.contains("system properties")) {

					jvmHelper.setSysConfig(line);;
				}
				
				if (line.contains("VM Arguments")) {

					jvmHelper.setOptions(line);
				}
				
				if (line.contains("os.version")) {

					jvmHelper.setOsVersion(line);
				}
				

				if (line.contains("java.version")) {

					tmpVersionA=line;
				}
				
				if (line.contains("java.vm.name")) {

					tmpVersionB=line;
				}

			}

			br.close();
			
			jvmHelper.setVersion(tmpVersionA+tmpVersionB);
			
			System.out.println(jvmHelper.getOptions());
			
			System.out.println(jvmHelper.getMaxHeapValue());
			
			System.out.println(jvmHelper.getThreadStackSizeValue());
			
			System.out.println(jvmHelper.JdkNumber());
			System.out.println(jvmHelper.isOS64Bit());
			

		} catch (IOException ioe) {
			System.out.println("Error: " + ioe);
			System.exit(-1);
		}
	}

}
